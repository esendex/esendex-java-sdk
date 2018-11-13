Esendex Java SDK
================

[![Build Status](https://travis-ci.org/esendex/esendex-java-sdk.svg?branch=master)](https://travis-ci.org/esendex/esendex-java-sdk)

The Esendex Java SDK is an easy to use client for the Esendex REST API which you can use to integrate SMS and Voice messaging into any application built with the JVM.

It contains a set of services for sending SMS and Voice messages, receiving SMS, tracking the status of your sent messages and more.

Full details at http://developers.esendex.com/SDKs/Java-SDK


## Logging

The SDK contains logging calls using the Apache Commons Logging framework. By default, this will write all log messages of INFO level or above to `System.err`.

To configure this logging, clients should follow the [configuration process for Apache Commons Logging](http://commons.apache.org/proper/commons-logging/apidocs/org/apache/commons/logging/package-summary.html). This will allow the SDK's logging to be integrated with that of the hosting application.

Logger instances are obtained on a per-class basis within the SDK based on the class name, so if your chosen framework supports configuring logging by context name you can target the SDK's messages by getting anything under the `esendex` toplevel namespace.

If you're not using a logging framework which Apache Commons Logging recognises then it will probably be defaulting to the `Jdk14Logger`, which uses `java.util.logging` to issue its log messages. This can be configured using its own configuration methods. For example, you can set the Esendex SDK to `WARNING` level or above:

> Logger.getLogger("esendex").setLevel(Level.WARNING);

Otherwise, you'll need to work out the appropriate configuration methods for your logging framework. To determine which one ACL is selecting, set the system property "org.apache.commons.logging.diagnostics.dest" to "STDOUT" or "STDERR" as preferred, and it will output all the steps in the discovery process for which log provider it selected.

For more information, consult the Apache Commons Logging user guide.