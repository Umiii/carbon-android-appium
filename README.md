# carbon-android-appium
appium automation for Carbon Test

## Installation
The project code assumes a Virtual Device is used, Virtual Device can be installed using
AVD Manager in Android Studio. Any Emulator targeting Android 10.0 and above would
suffice.

- Clone Project to your Local System
- Change emulator variable in base java file to the name of your emulator
- Install Maven (Project uses 3.6.3) (Skip if you have recent version of maven installed)
- Add testng as a dependency to project (test ng jar file is included)
- In Terminal - Run command `mvn compile`from project folder path

## Execution
Run command `mvn test` from project folder path. This should output test results in command line
if maven is intstalled and testng added as dependency as mentioned above
