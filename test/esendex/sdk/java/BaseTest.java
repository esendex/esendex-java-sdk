
package esendex.sdk.java;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.IServiceFactory;

public abstract class BaseTest {

    public static boolean IsSessionMode = false;

    public static final String USER 		= EsendexTestProperties.instance().getProperty(EsendexTestProperties.Key.USERNAME);
    public static final String PASSWORD 	= EsendexTestProperties.instance().getProperty(EsendexTestProperties.Key.PASSWORD);
    public static final String ACCOUNT 	= EsendexTestProperties.instance().getProperty(EsendexTestProperties.Key.ACCOUNT);
    public static final String DESTINATION_NUMBER = EsendexTestProperties.instance().getProperty(EsendexTestProperties.Key.DESTINATION_NUMBER);
	
	private static UserPassword userPassword = new UserPassword(USER, PASSWORD);


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
