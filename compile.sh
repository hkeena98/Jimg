#!/bin/bash

echo "Removing Class Files..."
rm *class
echo "Compiling Muser..."
javac -cp .:assets/jars/commons-io-2.6.jar Jimg.java
echo "Compile Complete"
java -cp .:assets/jars/commons-io-2.6.jar Jimg
