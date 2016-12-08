package esendex.sdk.java.service.resource.surveys;

import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;
import esendex.sdk.java.model.transfer.surveys.StandardReportDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.SurveysXmlResponderResource;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

public class SurveyReportResource extends SurveysXmlResponderResource<StandardReportDto> {

    private static EsendexProperties props = EsendexProperties.instance();

    public SurveyReportResource(Authenticator auth, String id, HttpQuery query) {
        super(auth, id, query, "1.0", props.getProperty(EsendexProperties.Key.SURVEYS_DOMAIN), props.getProperty(EsendexProperties.Key.SECURE).equals("true"));
    }

    @Override
    protected String getEndpointChild() {
        return "surveys/" + getId() + "/report/standard";
    }

    @Override
    protected HttpRequestMethod getRequestMethod() {
        return HttpRequestMethod.GET;
    }
}