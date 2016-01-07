package esendex.sdk.java.model.domain.impl;

import java.util.ArrayList;
import java.util.List;

import esendex.sdk.java.model.domain.response.ContactResponse;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;

public class ContactResponseAssembler {

	public ContactResponse createResponse(ContactDto dto) {

		ContactResponseImpl resp = new ContactResponseImpl();

		resp.setFirstName(dto.getFirstname());
		resp.setId(dto.getId());
        resp.setAccountReference(dto.getAccountReference());
		resp.setLastName(dto.getLastname());
		resp.setMobileNumber(dto.getPhoneNumber());
		resp.setQuickName(dto.getQuickname());


		return resp;
	}

	public List<ContactResponse> createCollectionResponse(ContactCollectionDto col) {

		List<ContactResponse> list = new ArrayList<ContactResponse>();
		if (col != null) {
			for (ContactDto dto : col.getContacts()) {
				list.add(createResponse(dto));
			}
		}
		return list;
	}
}
