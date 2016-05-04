package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.domain.impl.ContactRequestAssembler;
import esendex.sdk.java.model.domain.impl.ContactResponseAssembler;
import esendex.sdk.java.model.domain.request.ContactRequest;
import esendex.sdk.java.model.domain.response.ContactResponse;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.contact.ContactResponseDto;
import esendex.sdk.java.service.ContactService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.contact.*;

import java.util.List;

/**
 * A concrete ContactService implementation.
 *
 * @author Mike Whittaker
 */
public class ContactServiceImpl
		extends AbstractService implements ContactService {

	/**
	 * Instantiates a new contact service.
	 * @param authenticator the authenticator
	 */
	public ContactServiceImpl(Authenticator authenticator) {
		super(authenticator);
	}

	/**
	 * {@inheritDoc}
	 */
	public ContactResponse createContact(ContactRequest contactRequest) throws EsendexException {

		CreateContactResource resource = new CreateContactResource(authenticator);
        ContactDto contactDto = new ContactRequestAssembler().createContactDto(contactRequest);

        resource.setRequestObject(contactDto);
		resource.execute();

		ContactResponseDto resp = resource.getResponseObject();
		return new ContactResponseAssembler().createResponse(resp.getContact());
	}

	/**
	 * {@inheritDoc}
	 */
	public ContactResponse getContact(String id) throws EsendexException {

		RetrieveContactResource resource
			= new RetrieveContactResource(authenticator, id);
		resource.execute();
		return new ContactResponseAssembler().createResponse(
				resource.getResponseObject());
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContactResponse> getContacts(
			int pageNumber, int pageSize, String accountReference) throws EsendexException {

		HttpQuery query = new HttpQuery();
		query.addParameter(HttpQuery.START_INDEX, pageNumber);
		query.addParameter(HttpQuery.COUNT, pageSize);
        query.addParameter(HttpQuery.ACCOUNT_REFERENCE, accountReference);

		RetrieveContactsResource resource
			= new RetrieveContactsResource(authenticator, query);
		resource.execute();

		return new ContactResponseAssembler().createCollectionResponse(
				resource.getResponseObject());
	}

	/**
	 * {@inheritDoc}
	 */
	public ContactResponse updateContact(String id, ContactRequest contactRequest) throws EsendexException {

		UpdateContactResource resource = new UpdateContactResource(authenticator, id);

		ContactDto dto =
			new ContactRequestAssembler().createRequest(contactRequest);

		dto.setUri(resource.getEndpoint().toString() + "/");
		dto.setId(id);

		resource.setRequestObject(dto);
		resource.execute();

		return new ContactResponseAssembler().createResponse(
				resource.getResponseObject());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean deleteContact(String id) throws EsendexException {
		DeleteContactResource resource = new DeleteContactResource(authenticator, id);
		resource.execute();
		return resource.isHttpOkay();
	}


}
