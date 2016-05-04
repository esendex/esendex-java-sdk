
package esendex.sdk.java.service.resource.message;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

/**
 * This operation will return a paged response of all the sent messages from
 * Accounts that the user has permission to view. Provides for type safe
 * handling with instances that can handle any MessageHeaderResponse subclass.
 *
 * @author Mike Whittaker
 */
public class RetrieveSentMessagesResource
        extends XmlResponderResource<MessageCollectionResponseDto> {

    /**
     * Instantiates a new retrieve sent messages resource.
     *
     * @param auth  the authenticator
     * @param query the query
     */
    public RetrieveSentMessagesResource(Authenticator auth, HttpQuery query) {

        super(auth, null, null, query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getEndpointChild() {
        return "messageheaders";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HttpRequestMethod getRequestMethod() {
        return HttpRequestMethod.GET;
    }

}
