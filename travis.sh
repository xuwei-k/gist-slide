#!/bin/sh
SDK=appengine-java-sdk-1.7.4
SDK_ZIP=$SDK.zip
wget http://googleappengine.googlecode.com/files/$SDK_ZIP &&
unzip $SDK_ZIP &&
unset APPENGINE_SDK_HOME &&
export APPENGINE_SDK_HOME=./$SDK &&
wget https://raw.github.com/paulp/sbt-extras/master/sbt &&
chmod u+x ./sbt &&
./sbt -debug test
