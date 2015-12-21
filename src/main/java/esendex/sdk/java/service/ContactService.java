
package esendex.sdk.java.service;

import java.util.List;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.ContactRequest;
import esendex.sdk.java.model.domain.response.ContactResponse;

/**
 * A ContactService is a service for creating, retrieving, updating and deleting
 * contact resources. All methods throw an EsendexException to indicate either
 * a problem during the underlying connection or there was a none okay response.
 *
 * @author Mike Whittaker
 */
public interface ContactService {

	ContactResponse createContact(ContactRequest contactRequest) throws EsendexException;

	boolean createContacts(List<ContactRequest> contactRequests) throws EsendexException;

    /**
     * @param id the id of the desired contact
     */
	ContactResponse getContact(String id) throws EsendexException;

    /**
     * @param pageNumber the page number
     * @param pageSize the page size
     * @param accountReference the accountReference
     */
	List<ContactResponse> getContacts(int pageNumber, int pageSize, String accountReference) throws EsendexException;

    /**
     * @param id the id of the desired contact
     * @param contactRequest the contact request object
     */
	ContactResponse updateContact(String id, ContactRequest contactRequest) throws EsendexException;

    /**
     * @param id the id of the desired contact
     */
	boolean deleteContact(String id) throws EsendexException;

}