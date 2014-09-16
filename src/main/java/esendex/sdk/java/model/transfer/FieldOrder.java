package esendex.sdk.java.model.transfer;

import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.contact.ContactGroupDto;
import esendex.sdk.java.model.transfer.message.MessageCollectionRequestDto;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.model.transfer.message.MessageRequestDto;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;

import java.util.ArrayList;
import java.util.List;

public class FieldOrder {
	
	private Class<? extends Dto> clazz;
	private String[] fieldOrder;
	
	private static final List<FieldOrder> fieldOrders = new ArrayList<FieldOrder>();
	
	static {
		fieldOrders.add(new FieldOrder(
				MessageRequestDto.class,  new String[] {
					"id", "uri", "xmlns", "from", "to", "type", "body", 
					"lang", "retries", "validity"}));

		fieldOrders.add(new FieldOrder(
				MessageCollectionRequestDto.class,  new String[]{
					"id", "uri", "xmlns", "accountreference", "from", "type", 
					"lang", "retries", "validity", "sendat", "messages"}));

		fieldOrders.add(new FieldOrder(
				MessageResponseDto.class,  new String[] {
					"id", "uri", "xmlns", "reference", "status", "sentat", "deliveredat", 
					"receivedat", "type", "to", "from", "laststatusat", 
					"submittedat", "summary", "body", "direction", "parts", 
					"username", "readat", "readby"}));
		
		fieldOrders.add(new FieldOrder(
				MessageCollectionResponseDto.class,  new String[] {
					"id", "uri", "xmlns", "batchid", "startindex", "count", "totalcount", "messageheaders"}));

		fieldOrders.add(new FieldOrder(
				ContactDto.class,  new String[] {
					"id", "uri", "xmlns", "concurrencyid", "firstname", "lastname", 
					"quickname", "mobilenumber", "type", "groups", "owner"}));
		
		fieldOrders.add(new FieldOrder(
				ContactCollectionDto.class,  new String[] {
					"id", "uri", "xmlns", "startindex", "count", "totalcount", "contacts"}));
		
		fieldOrders.add(new FieldOrder(
				ContactGroupDto.class,  new String[] {
					"id", "uri", "xmlns", "contactcount", "name", "type"}));
		
//		fieldOrders.add(new FieldOrders(
//				.class,  
//				new String[] {}));

					
	}
	
	public FieldOrder(Class<? extends Dto> clazz, String[] fieldOrder) {
		this.clazz = clazz;
		this.fieldOrder = fieldOrder;
	}
	
	public static List<FieldOrder> getFieldOrders() {
		return fieldOrders;
	}
	
	public String[] getFieldOrder() {
		return fieldOrder;
	}
	
	public Class<? extends Dto> getFieldOrderClass() {
		return clazz;
	}

}
