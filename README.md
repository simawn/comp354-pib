# Codenames

![image](https://drive.google.com/uc?export=view&id=16011UQ-yv_0t4Q86A45mW_bUYCFVEywY)

## Requirements

- Java Version 8/1.8 or Java Version 9
	To check the version number, use the following in cmd prompt / terminal:
	```
	java -version
	```
	**Note: Compiling source code in Java 9 does not allow Java 8/1.8 users to run the code. They would need to re-compile it. However, Java 9 users may run Java 8/1.8 code**
	
## Usage 

### Running the exported .jar file
1. Simply double click `Codenames.jar` in the `/Codenames_IT2` folder to run the application

**Note:** Make sure the `/resources` folder and `Codenames.jar` are in the same folder. Avoid modifying or deleteing the contents of `/resources`.

Executing `CodenamesConsole_bat.bat` or `CodenamesConolse_sh.sh` will run the game along with the debug console.

### Instructions for running in Eclipse

1. Ensure that the requirements have been met. The project will fail to run on JDK-11+ since the javaFX library has been removed from these versions.

2. Import the project directory into the IDE of choice. Note that we used NetBeans/IntelliJ in this project. 

    * To run the project in Eclipse, go to File -> New -> Java Project.  Un-check "Use default location" and set the Location to the directory containing src, resources, and tests.
Click Next, and go to the Libraries tab and add JUnit 5 (if you want to run the unit tests). Click Finish.

3. Ensure that the working directory is the main project directory, and not a sub-directory of the main project. This avoids path issues relating to the resources folder. 

4. Compile the project and run the entry class "Codenames.java" within the project directory.

### Play Game
To cycle through the game, simply press *Enter* key. Every invocation of this key allows for either the Operative or the Spymaster to perform an action.

### Verbose View
To have an informative log of the game, press *V* key. This will show a new window with which the logs will be displayed for every phase of the game in the main game window. 

## Dependency Tree

### UML Diagram

![image](https://drive.google.com/uc?export=view&id=1omf_et8GsZn5pPZziDwZVTSH6asKY6zl)


### Visual Web

![image](https://drive.google.com/uc?export=view&id=1qw0Oeij9mqHS15xMVfIckwBrn_xEoN9I)
