
package esendex.sdk.java.example;

import java.text.ParseException;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.model.domain.request.ContactRequest;
import esendex.sdk.java.model.domain.response.ContactResponse;
import esendex.sdk.java.service.BasicServiceFactory;
import esendex.sdk.java.service.ContactService;
import esendex.sdk.java.service.auth.UserPassword;

/**
 * Example of how to create a contact
 * @author Mike Whittaker
 */
public class CreateContactSample {
		
	public void create() throws ParseException {

		// Create a factory for creating services based on preferred authentication strategy
		BasicServiceFactory factory = 
			ServiceFactory.createBasicAuthenticatingFactory(getUserPassword());
		
		// Get the service for dealing with contacts
		ContactService service = factory.getContactService();
		
		// create the contact with mandatory fields
		ContactRequest contact = new ContactRequest("freddy", "447879000000");
		
		// set other optional fields
		contact.setFirstName("Fred");
		contact.setLastName("Flintstone");
				
		// Call createContact to execute the service request and obtain a response 
		ContactResponse resp;
		try {
			resp = service.createContact(contact);
		} catch (EsendexException e) { // indicates a problem with the service
			// handle any exception thrown	
			e.printStackTrace();
			return;
		}
		
		// obtain the concurrency ID that changes when the contact changes
		resp.getConcurrencyId();
		
		// get the GUID to identify the contact and will never change
		resp.getId();
				
		// And print out the contact
		print(resp);
	}
	
	// provide a valid account username and password
	private UserPassword getUserPassword() {
		return new UserPassword("Username", "Password");
	}
	
	private void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void main(String[] args) throws ParseException {
		new CreateContactSample().create();
	}

}
