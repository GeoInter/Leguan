@echo off

:: Run mvn package with different profiles and parameters
call mvn clean
:: linux
call mvn package "-Djavafx.platform=linux" "-Dapp.name=Leguan-linux.sh" -P shell -f .\build_pom.xml
call mvn package "-Djavafx.platform=linux-aarch64" "-Dapp.name=Leguan-linux-aarch64.sh" -P shell -f .\build_pom.xml

:: mac
call mvn package "-Djavafx.platform=mac" "-Dapp.name=Leguan-mac.sh" -P shell -f .\build_pom.xml
call mvn package "-Djavafx.platform=mac-aarch64" "-Dapp.name=Leguan-mac-aarch64.sh" -P shell -f .\build_pom.xml

:: windows (x64)
call mvn package "-Djavafx.platform=win" "-Dapp.name=Leguan.exe" -P exe -f .\build_pom.xml