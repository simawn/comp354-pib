# Codenames

![image](https://drive.google.com/uc?export=view&id=16011UQ-yv_0t4Q86A45mW_bUYCFVEywY)

## Requirements

- Java Version 8/1.8 or Java Version 9
	To check the version number, use the following in cmd prompt / terminal:
	```
	java -version
	```
	**Note: Compiling source code in Java 9 does not allow Java 8/1.8 users to run the code. They would need to re-compile it. However, Java 9 users may run Java 8/1.8 code**

## Instructions for running

1 - Ensure that the requirements have been met. The project will fail to run on JDK-11+ since the javaFX library has been removed from these versions.

2 - Import the project directory into the IDE of choice. Note that we used NetBeans/IntelliJ in this project.

3 - Ensure that the working directory is the main project directory, and not a sub-directory of the main project. This avoids path issues relating to the resources folder. 

4 - Compile the project and run the entry class "Codenames.java" within the project directory.
	4.a - If the project fails to compile due to missing URL/Path issues, copy the resources folder into the out/bin folder and re-run. 


## Usage

### Play Game
To cycle through the game, simply press *Enter* key. Every invocation of this key allows for either the Operative or the Spymaster to perform an action.

### Verbose View
To have an informative log of the game, press *V* key. This will show a new window with which the logs will be displayed for every phase of the game in the main game window. 


## Dependency Tree

### UML Diagram

![image](https://drive.google.com/uc?export=view&id=1omf_et8GsZn5pPZziDwZVTSH6asKY6zl)


### Visual Web

![image](https://drive.google.com/uc?export=view&id=1qw0Oeij9mqHS15xMVfIckwBrn_xEoN9I)
