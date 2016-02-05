package esendex.sdk.java.model.transfer;

import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.message.*;
import esendex.sdk.java.model.transfer.surveys.RecipientDto;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;
import esendex.sdk.java.model.transfer.surveys.TemplateFieldDto;
import esendex.sdk.java.model.transfer.surveys.TemplateFieldsDto;

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
					"username", "readat", "readby", "failurereason"}));

		fieldOrders.add(new FieldOrder(
				MessageCollectionResponseDto.class,  new String[] {
					"id", "uri", "xmlns", "batchid", "startindex", "count", "totalcount", "messageheaders"}));

		fieldOrders.add(new FieldOrder(
				FailureReasonDto.class, new String[]{
				"code", "description", "permanentfailure"}));

		fieldOrders.add(new FieldOrder(
				ContactDto.class,  new String[] {
					"id", "uri", "xmlns", "firstname", "lastname",
					"quickname", "phonenumber", "accountreference"}));

		fieldOrders.add(new FieldOrder(
				ContactCollectionDto.class,  new String[] {
					"id", "uri", "xmlns", "startindex", "count", "totalcount", "contacts"}));

		fieldOrders.add(new FieldOrder(
				RecipientsDto.class,  new String[] {
				"uri", "xmlns", "recipients"}));

		fieldOrders.add(new FieldOrder(
				RecipientDto.class,  new String[] {
				"uri", "xmlns", "phonenumber", "templatefields"}));

		fieldOrders.add(new FieldOrder(
				TemplateFieldDto.class,  new String[] {
				"uri", "xmlns", "name", "value"}));

		fieldOrders.add(new FieldOrder(
				TemplateFieldsDto.class,  new String[] {
				"uri", "xmlns", "templatefield"}));

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
