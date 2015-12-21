
package esendex.sdk.java.parser.xstream;

import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.FieldDictionary;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.SortableFieldKeySorter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.transfer.FieldOrder;
import esendex.sdk.java.model.transfer.PageableDto;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.message.BodyDto;
import esendex.sdk.java.model.transfer.message.MessageCollectionRequestDto;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.model.transfer.message.MessageRequestDto;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;
import esendex.sdk.java.model.transfer.session.SessionDto;
import esendex.sdk.java.parser.EsendexCasedEnumConverter;
import esendex.sdk.java.parser.InvalidXmlException;
import esendex.sdk.java.parser.EmptyToNullDateConverter;
import esendex.sdk.java.parser.UnmappableException;
import esendex.sdk.java.parser.XmlParser;

/**
 * XmlParser that uses the XStream library to convert between XML and Dto
 * Objects.
 *
 * @author Mike Whittaker
 */
public class XStreamParser implements XmlParser {

	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(XStreamParser.class);

	private XStream xStream;

	/**
	 * Instantiate the parser by configuration of the underlying XStream
	 * instance. Developers are directed to XStream documentation for details on
	 * how to modify this configuration.
	 */
	public XStreamParser() {

		xStream = createXStream();

		// General aliases
		xStream.useAttributeFor(Dto.class, "id");
		xStream.useAttributeFor(Dto.class, "uri");
		xStream.useAttributeFor(Dto.class, "xmlns");
		xStream.useAttributeFor(PageableDto.class, "totalcount");
		xStream.useAttributeFor(PageableDto.class, "count");
		xStream.useAttributeFor(PageableDto.class, "startindex");

		// General converters
		xStream.registerConverter(new EmptyToNullDateConverter());
		xStream.registerConverter(new EsendexCasedEnumConverter());

		// Session
		xStream.alias("session", SessionDto.class);

		// Contacts
		xStream.alias("contact", ContactDto.class);
        xStream.omitField(ContactDto.class, "groups");
        xStream.omitField(ContactDto.class, "link");

		xStream.alias("contacts", ContactCollectionDto.class);
		xStream.addImplicitCollection(ContactCollectionDto.class, "contacts");
        xStream.omitField(ContactCollectionDto.class, "link");

		// Message (request)
		xStream.alias("message", MessageRequestDto.class);
		xStream.addImmutableType(MessageRequestDto.class);

		// Messages (request)
		xStream.alias("messages", MessageCollectionRequestDto.class);
		xStream.addImplicitCollection(
				MessageCollectionRequestDto.class, "messages",
				MessageRequestDto.class);

		// MessageHeader (response)
		xStream.alias("body", BodyDto.class);
		xStream.alias("messageheader", MessageResponseDto.class);

		// MessageHeaders (response)
		xStream.useAttributeFor(MessageCollectionResponseDto.class, "batchid");
		xStream.alias("messageheaders", MessageCollectionResponseDto.class);
		xStream.addImplicitCollection(
				MessageCollectionResponseDto.class, "messageheaders",
				MessageResponseDto.class);
	}

	// configures the field order for the DTOs
	private static XStream createXStream() {
		SortableFieldKeySorter sorter = new SortableFieldKeySorter();
		for(FieldOrder fo : FieldOrder.getFieldOrders()) {
			sorter.registerFieldOrder(
					fo.getFieldOrderClass(), fo.getFieldOrder());
		}
		return new XStream(new PureJavaReflectionProvider(new FieldDictionary(sorter)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dto fromXml(String xml) throws EsendexException {
		try {
			return (Dto)xStream.fromXML(xml);
		} catch (ClassCastException ex) {
			throw new UnmappableException("Could not map to a Dto", ex);
		} catch (StreamException ex) {
			throw new InvalidXmlException(ex);
		} catch (CannotResolveClassException ex) {
			throw new UnmappableException("Could not map to an Object", ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toXml(Dto dto) {

		dto.setXmlns(EsendexProperties.instance().getProperty(
				EsendexProperties.Key.NAMESPACE));

		String declaration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

		StringWriter writer = new StringWriter();
		xStream.marshal(dto, new CompactWriter(writer));
		String xml = declaration + writer.toString();
		return xml;
	}

}
