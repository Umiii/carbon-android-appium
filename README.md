# carbon-android-appium
appium automation for Carbon Test

## Installation
The project code assumes a Virtual Device is used, Virtual Device can be installed using
AVD Manager in Android Studio. Any Emulator targeting Android 10.0 and above would
suffice. The name of your Virtual Device (Emulator name) should correspond with
the name given in step 2 below.

- Clone Project to your Local System
- Change emulator variable in base java file to the name of your emulator
- Install appium from terminal using npm command `npm install -g appium`
- Install Maven (Project uses 3.6.3) (Skip if you have recent version of maven installed)
- Add testng as a dependency to project (test ng jar file is included)
- Run Emulator and Appium Server
- In Terminal - Run command `mvn compile`from project folder path

## Execution
Run command `mvn test` from project folder path. This should output test results in command line
if maven is intstalled and testng added as dependency as mentioned above

*NOTE ON INSTALLATION*
Appium and Surefire jar files have been added as dependencies in the pom.xml, however if there
are any errors related to these while running test,manually add these jar files as
dependencies of project.
