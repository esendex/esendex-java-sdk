package com.esendex.java.sdk.integration;
import com.esendex.java.sdk.UnitTest;
import com.esendex.java.sdk.integration.contactsservice.ContactsServiceGetContactIT;
import com.esendex.java.sdk.integration.inboxservice.InboxServiceMarkIT;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UnitTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
