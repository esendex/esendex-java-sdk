
package esendex.sdk.java.parser.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.transfer.LinkDto;
import esendex.sdk.java.model.transfer.PageableDto;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.contact.ContactResponseDto;
import esendex.sdk.java.model.transfer.message.*;
import esendex.sdk.java.model.transfer.optout.*;
import esendex.sdk.java.model.transfer.session.SessionDto;
import esendex.sdk.java.model.transfer.surveys.*;
import esendex.sdk.java.parser.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.StringWriter;
import java.util.Map;

/**
 * XmlParser that uses the XStream library to convert between XML and Dto
 * Objects.
 *
 * @author Mike Whittaker
 */
public class SurveysXStreamParser implements XmlParser {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(SurveysXStreamParser.class);

    private XStream xStream;

    /**
     * Instantiate the parser by configuration of the underlying XStream
     * instance. Developers are directed to XStream documentation for details on
     * how to modify this configuration.
     */
    public SurveysXStreamParser() {

        xStream = createXStream();
        xStream.ignoreUnknownElements();


        // General aliases
        xStream.useAttributeFor(Dto.class, "id");
        xStream.useAttributeFor(Dto.class, "uri");
        xStream.useAttributeFor(Dto.class, "xmlns");

        // General converters
        xStream.registerConverter(new EmptyToNullDateConverter());

        //Surveys - send
        xStream.processAnnotations(RecipientDto.class);
        xStream.processAnnotations(RecipientsDto.class);
        xStream.processAnnotations(TemplateFieldDto.class);
        xStream.processAnnotations(TemplateFieldsDto.class);

        //Surveys - standard report
        xStream.processAnnotations(StandardReportDto.class);
        xStream.alias("rows", StandardReportDto.class);
        xStream.registerConverter(new RecipientDataConverter());

        xStream.alias("error", SurveyReportErrorDto.class);
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
