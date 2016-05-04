package com.esendex.java.sdk;

import com.pyruby.stubserver.Expectation;
import com.pyruby.stubserver.StubMethod;
import com.pyruby.stubserver.StubServer;
import esendex.sdk.java.EsendexProperties;

public class TestServer {
    private static Integer lastPort = 44000;
    private String originalDomain;
    private StubServer server;
    private Integer port;

    public TestServer() {
        port = lastPort++;

        EsendexProperties properties = EsendexProperties.instance();
        originalDomain = properties.getProperty(EsendexProperties.Key.DOMAIN);
        properties.setProperty("esendex.domain", "localhost:" + Integer.toString(port));

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
        EsendexProperties.instance().setProperty("esendex.domain", originalDomain);
    }
}
