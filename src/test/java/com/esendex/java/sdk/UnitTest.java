package com.esendex.java.sdk;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.transfer.contact.ContactResponseDto;
import esendex.sdk.java.model.transfer.contact.NewContactDto;
import esendex.sdk.java.service.resource.base.XmlResponder;
import org.junit.Test;

public class UnitTest {

    @Test
    public void thenAstuff() throws EsendexException {

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<response xmlns=\"http://api.esendex.com/ns/\">\n" +
                "    <contact id=\"9abea48b-2aa7-475e-b83e-57f9f47eaad8\">\n" +
                "        <firstname />\n" +
                "        <lastname />\n" +
                "        <quickname>adasd111aaa1</quickname>\n" +
                "        <phonenumber>44787134312</phonenumber>\n" +
                "        <accountreference>EX0067551</accountreference>\n" +
                "        <link rel=\"self\" href=\"http://api.dev.esendex.com/v2.0/contacts/9abea48b-2aa7-475e-b83e-57f9f47eaad8\" />\n" +
                "        <link rel=\"account\" href=\"http://api.dev.esendex.com/v1.0/accounts/a703d623-c0bd-422d-9c33-ed48f21d2697\" />\n" +
                "    </contact>\n" +
                "</response>";

        XmlResponder<ContactResponseDto> newContactDtoXmlResponder = new XmlResponder<ContactResponseDto>(xml);

    }
}
