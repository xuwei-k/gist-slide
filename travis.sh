#!/bin/sh
SDK=appengine-java-sdk-1.9.2
SDK_ZIP=$SDK.zip
wget https://commondatastorage.googleapis.com/appengine-sdks/featured/$SDK_ZIP &&
unzip $SDK_ZIP &&
unset APPENGINE_SDK_HOME &&
export APPENGINE_SDK_HOME=./$SDK &&
sbt test
