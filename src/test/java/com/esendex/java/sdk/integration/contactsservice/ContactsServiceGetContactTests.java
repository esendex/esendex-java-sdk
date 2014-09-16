package com.esendex.java.sdk.integration.contactsservice;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.ContactResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactsServiceGetContactTests extends BaseTest {

    private static List<ContactResponse> expectedContacts;
    private static List<ContactResponse> actualContacts;

    @BeforeClass
    public static void whenGettingContacts() throws EsendexException {

        expectedContacts = getFactory().getContactService().getContacts(0, 5);

        actualContacts = new Vector<ContactResponse>();
        for (ContactResponse expectedContact : expectedContacts) {
            ContactResponse contact = getFactory().getContactService().getContact(expectedContact.getId());

            actualContacts.add(contact);
        }

    }

    @Test
    public void thenTheContactsContainTheExpectedData() {

        for (ContactResponse expectedContact : expectedContacts) {

            ContactResponse actual = getActualContactResponseForId(expectedContact.getId());

            assertEquals(actual.getMobileNumber(),expectedContact.getMobileNumber());
            assertEquals(actual.getQuickName(),expectedContact.getQuickName());
            assertEquals(actual.getFirstName(),expectedContact.getFirstName());
            assertEquals(actual.getLastName(),expectedContact.getLastName());
            assertEquals(actual.getId(),expectedContact.getId());
            assertEquals(actual.getType(),expectedContact.getType());
        }
    }

    private ContactResponse getActualContactResponseForId(String id) {

        for(ContactResponse actualContact : actualContacts) {
            if ( actualContact.getId().equals(id) ) {
                return actualContact;
            }
        }
        return null;
    }

}
