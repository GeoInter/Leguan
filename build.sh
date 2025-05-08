#!/bin/bash

# Run mvn package with different profiles and parameters
mvn clean
# linux
mvn package "-Djavafx.platform=linux" "-Dapp.name=Leguan-linux.sh" -P shell -f .\pom.xml
mvn package "-Djavafx.platform=linux-aarch64" "-Dapp.name=Leguan-linux-aarch64.sh" -P shell -f .\pom.xml

#mac
mvn package "-Djavafx.platform=mac" "-Dapp.name=Leguan-mac.sh" -P shell -f .\pom.xml
mvn package "-Djavafx.platform=mac-aarch64" "-Dapp.name=Leguan-mac-aarch64.sh" -P shell -f .\pom.xml

# windows (x64)
mvn package "-Djavafx.platform=win" "-Dapp.name=Leguan.exe" -P exe -f .\pom.xml