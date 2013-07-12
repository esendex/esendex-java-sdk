
package esendex.sdk.java.example;

import java.text.ParseException;
import java.util.List;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import esendex.sdk.java.service.SessionServiceFactory;
import esendex.sdk.java.service.auth.UserPassword;

/**
 * Example of how to retrieve messages from inbox
 * @author Mike Whittaker
 */
public class GetInboxMessageSample {

	public void retrieve() throws ParseException {

		// Create a factory for creating services based on preferred authentication strategy
		SessionServiceFactory factory;
		try {
			factory = ServiceFactory.createSessionAuthenticatingFactory(getUserPassword());
		} catch (EsendexException ex) {
			ex.printStackTrace();
			return;
		}
		
		// Get the service for retrieving inbox messages
		InboxService service = factory.getInboxService();
				
		// Call getMessages to execute the service request and obtain a response 
		InboxMessageCollectionResponse resp;
		try {
			// in this case the request is pageable and we obtain the first 10 messages
			resp = service.getMessages(0, 10);
		} catch (EsendexException e) { // indicates a problem with the service
			// handle any exception thrown	
			e.printStackTrace();
			return;
		}
		
		// the response contains some paging information 
		// such as number of messages retreived on this request, 
		resp.getCount();
		// the total number of messages available
		resp.getTotalCount();
		// and the index of the first message returned
		resp.getStartIndex();
		
		// retrieve the actual messages from the response
		List<InboxMessageResponse> messages = resp.getMessages();	
				
		// And print out the messages
		print(messages);
	}
	
	// provide a valid account username and password
	private UserPassword getUserPassword() {
		return new UserPassword("Username", "Password");
	}
	
	private void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void main(String[] args) throws ParseException {
		new GetInboxMessageSample().retrieve();
	}

}
