package com.esendex.java.sdk;

import esendex.sdk.java.EsendexProperties;

public abstract class BaseTest {
    static {
        EsendexProperties.instance().setProperty("esendex.secure", "false");
    }
}
