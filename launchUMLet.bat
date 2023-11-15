@rem Copy this file to where umlet.jar exists
@rem Replace "where/JDK/is/installed" with the path to your JDK installation
@echo off
set JAVA_HOME=where/JDK/is/installed
set PATH=%PATH%;%JAVA_HOME%/bin
echo "JAVA_HOME: %JAVA_HOME%"
echo "PATH: %PATH%"
java -jar umlet.jar
pause

