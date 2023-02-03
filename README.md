Esendex Java SDK
================

[![Build Status](https://travis-ci.org/esendex/esendex-java-sdk.svg?branch=master)](https://travis-ci.org/esendex/esendex-java-sdk)

The Esendex Java SDK is an easy to use client for the Esendex REST API which you can use to integrate SMS and Voice messaging into any application built with the JVM.

It contains a set of services for sending SMS and Voice messages, receiving SMS, tracking the status of your sent messages and more.

Full details at http://developers.esendex.com/SDKs/Java-SDK


## Logging

The SDK contains logging calls using the Apache Commons Logging framework. This logging is expected to be helpful only for diagnostic purposes, and logs only at DEBUG level.

**Please note** that the DEBUG level log messages include the entirety of messages sent to and from the Esendex servers, and will thus contain message contents, recipients and originators. This almost certainly contains personally identifiable information (PID), and so the DEBUG level logging should be used only with appropriate consideration.

To configure this logging, clients should follow the [configuration process for Apache Commons Logging](http://commons.apache.org/proper/commons-logging/apidocs/org/apache/commons/logging/package-summary.html). This will allow the SDK's logging to be integrated with that of the hosting application.

Logger instances are obtained on a per-class basis within the SDK based on the class name, so if your chosen framework supports configuring logging by context name you can target the SDK's messages by getting anything under the `esendex` toplevel namespace.

If you're not using a logging framework which Apache Commons Logging recognises then it will probably be defaulting to the `Jdk14Logger`, which uses `java.util.logging` to issue its log messages. This can be configured using its own configuration methods. For example, you can turn on the DEBUG logging for the Esendex SDK:

> Logger.getLogger("esendex").setLevel(Level.DEBUG);

Otherwise, you'll need to work out the appropriate configuration methods for your logging framework. To determine which one ACL is selecting, set the system property "org.apache.commons.logging.diagnostics.dest" to "STDOUT" or "STDERR" as preferred, and it will output all the steps in the discovery process for which log provider it selected.

For more information, consult the Apache Commons Logging user guide.

##Https Connections

In order to enable **https** transport layer in the esendex java library you must enable the property 

> esendex.secure=true

in the file `esendex.properties`

This goes through the basic `esendex.sdk.java.service.resource.base.Resource` class which reads the value from the properties file.

Other abstract classes used in this library just set the *https* by default, without reading the property files, for example:

- BaseSurveryResource
- SurveySendResource
- XmlResponderResource




## Development

To run all the tests you need an active Esendex account with permissions on the full set of supported Esendex products.

Copy `esendex_test.properties.example` as `esendex_test.properties` and fill in your account information and a mobile number used as a message target.

The selected account must have at least 1 recent message in its inbox in order for all of the tests to succeed.

Esendex developers can use the `tests.domain` key to run the tests against alternate environments.

### Version Numbers

When updating, don't forget to edit `pom.xml` to update the version number appropriately.