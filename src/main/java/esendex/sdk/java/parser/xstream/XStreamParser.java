
package esendex.sdk.java.parser.xstream;

import java.io.StringWriter;

import esendex.sdk.java.model.transfer.LinkDto;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.contact.ContactResponseDto;
import esendex.sdk.java.model.transfer.message.*;
import esendex.sdk.java.model.transfer.optout.*;
import esendex.sdk.java.model.transfer.surveys.*;
import esendex.sdk.java.parser.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.security.AnyTypePermission;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.transfer.PageableDto;
import esendex.sdk.java.model.transfer.session.SessionDto;

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
        xStream.ignoreUnknownElements();


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
        xStream.alias("contacts", ContactCollectionDto.class);
        xStream.addImplicitCollection(ContactCollectionDto.class, "contacts");

        xStream.processAnnotations(ContactDto.class);
        xStream.processAnnotations(ContactResponseDto.class);
        xStream.processAnnotations(LinkDto.class);

        //Surveys - send
        xStream.processAnnotations(RecipientDto.class);
        xStream.processAnnotations(RecipientsDto.class);
        xStream.processAnnotations(TemplateFieldDto.class);
        xStream.processAnnotations(TemplateFieldsDto.class);

        //Surveys - standard report
        xStream.processAnnotations(StandardReportDto.class);
        xStream.alias("rows", StandardReportDto.class);
        xStream.registerConverter(new RecipientDataConverter());

        //OptOuts
        xStream.alias("optouts", OptOutCollectionResponseDto.class);
        xStream.addImplicitCollection(OptOutCollectionResponseDto.class, "optouts");

        xStream.processAnnotations(FromAddressDto.class);
        xStream.processAnnotations(OptOutRequestDto.class);
        xStream.processAnnotations(OptOutResponseDto.class);
        xStream.processAnnotations(OptOutCreateResponseDto.class);

        // Message (request)
        xStream.alias("message", MessageRequestDto.class);
        xStream.addImmutableType(MessageRequestDto.class, true);

        // Messages (request)
        xStream.alias("messages", MessageCollectionRequestDto.class);
        xStream.addImplicitCollection(
                MessageCollectionRequestDto.class, "messages",
                MessageRequestDto.class);

        // MessageHeader (response)
        xStream.alias("body", BodyDto.class);
        xStream.alias("failurereason", FailureReasonDto.class);
        xStream.alias("messageheader", MessageResponseDto.class);

        // MessageHeaders (response)
        xStream.useAttributeFor(MessageCollectionResponseDto.class, "batchid");
        xStream.alias("messageheaders", MessageCollectionResponseDto.class);
        xStream.addImplicitCollection(
                MessageCollectionResponseDto.class, "messageheaders",
                MessageResponseDto.class);
    
    
        xStream.addPermission(AnyTypePermission.ANY);
    }

    // configures the field order for the DTOs
    private static XStream createXStream() {
        return new XStream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object fromXml(String xml) throws EsendexException {
        try {
            return xStream.fromXML(xml);
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
