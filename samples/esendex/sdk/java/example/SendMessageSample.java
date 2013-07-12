
package esendex.sdk.java.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.model.domain.request.SmsMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.model.domain.response.ResourceLinkResponse;
import esendex.sdk.java.service.BasicServiceFactory;
import esendex.sdk.java.service.MessagingService;
import esendex.sdk.java.service.auth.UserPassword;

/**
 * Example of how to send a message
 * @author Mike Whittaker
 */
public class SendMessageSample {
		
	public void send() throws ParseException {
		
		// Create an sms message request with phone number and message body
		SmsMessageRequest m = new SmsMessageRequest("447879000000", "body text");
		
		// Create a collection to hold the single message to send from specified account
		SmsMessageCollectionRequest c = new SmsMessageCollectionRequest(getAccount(), m);	
		
		// Add optional fields to the message
		m.setBody("Test Message from SendMessageSample");
		m.setFrom("447879000000");
		m.setValidity(5);
		// other fields...
		
		// Add optional fields that act as defaults
		c.setFrom("447879999999");
		// other fields...

		// Create a factory for creating services based on preferred authentication strategy
		BasicServiceFactory factory = 
			ServiceFactory.createBasicAuthenticatingFactory(getUserPassword());
		
		// Get the service for sending messages
		MessagingService service = factory.getMessagingService();
		
		// Call sendMessages to execute the service request and obtain a response 
		MessageResultResponse resp;	
		try {
			Date sendAt = new SimpleDateFormat("dd-MM-yyyy").parse("01-04-2012");
			resp = service.sendScheduledMessages(c, sendAt);
		} catch (EsendexException ex) { // indicates a problem with the service
			// handle any exception thrown
			ex.printStackTrace();
			return;
		}
		
		// Call getMessages on the repsonse to get the list of message responses
		List<ResourceLinkResponse> messages = resp.getMessageIds();
		
		// Here we print out the message responses
		print(messages);
	}
	
	// provide a valid account
	private String getAccount() {
		return "EX-----";
	}
	
	// provide a valid account username and password
	private UserPassword getUserPassword() {
		return new UserPassword("Username", "Password");
	}
	
	private void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void main(String[] args) throws ParseException {
		new SendMessageSample().send();
	}

}
