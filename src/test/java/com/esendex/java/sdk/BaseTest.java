package com.esendex.java.sdk;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.IServiceFactory;

public abstract class BaseTest {

    public static boolean IsSessionMode = false;

    public static final String USER;
    public static final String PASSWORD;
    public static final String ACCOUNT;
    public static final String DESTINATION_NUMBER;
	private static final UserPassword userPassword;


    static {
        EsendexTestProperties testProperties = EsendexTestProperties.instance();

        USER = testProperties.getUsername();
        PASSWORD = testProperties.getPassword();
        ACCOUNT = testProperties.getAccount();
        DESTINATION_NUMBER = testProperties.getDestinationNumber();

        userPassword = new UserPassword(USER, PASSWORD);

        String domain = testProperties.getDomain();

        if(domain != null)
            EsendexProperties.instance().setProperty("esendex.domain", domain);
    }

    public static IServiceFactory getFactory() throws EsendexException {
        return IsSessionMode
                ? getBasicFactory()
                : getSessionFactory();
    }

    private static IServiceFactory getBasicFactory() {

        if (basicFactory == null)
            basicFactory = ServiceFactory.createBasicAuthenticatingFactory(userPassword);
        return basicFactory;
    }
    private static IServiceFactory basicFactory;

    private static IServiceFactory getSessionFactory() throws EsendexException {

        if (sessionFactory == null)
            sessionFactory = ServiceFactory.createSessionAuthenticatingFactory(userPassword);
        return sessionFactory;
    }
    private static IServiceFactory sessionFactory;
}
