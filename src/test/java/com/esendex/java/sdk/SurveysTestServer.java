package com.esendex.java.sdk;

import com.pyruby.stubserver.Expectation;
import com.pyruby.stubserver.StubMethod;
import com.pyruby.stubserver.StubServer;
import esendex.sdk.java.EsendexProperties;

public class SurveysTestServer {
    private static Integer lastPort = 44000;
    private String originalDomain;
    private StubServer server;
    private Integer port;

    public SurveysTestServer() {
        port = lastPort++;

        EsendexProperties properties = EsendexProperties.instance();
        originalDomain = properties.getProperty(EsendexProperties.Key.SURVEYS_DOMAIN);
        properties.setProperty("esendex.surveys_domain", "localhost:" + Integer.toString(port));
        properties.setProperty("esendex.secure", "false");

        server = new StubServer(port);
    }

    public void start() {
        server.start();
    }

    public Expectation expect(StubMethod stubMethod) {
        return server.expect(stubMethod);
    }

    public void verify() {
        server.verify();
    }

    public void stop() {
        server.stop();
        EsendexProperties.instance().setProperty("esendex.surveys_domain", originalDomain);
        EsendexProperties.instance().setProperty("esendex.secure", "true");
    }
}
