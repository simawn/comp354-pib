# Codenames


![image](https://drive.google.com/uc?export=view&id=1iULsCRsBDgCbQs45UTBxQallmXX1vwEA)


![image](https://drive.google.com/uc?export=view&id=1Ny0GUSe5mrKGhEXX9AZ6cm-LiqWQMDCK)


## Requirements

- Java Version 8/1.8 or Java Version 9
	To check the version number, use the following in cmd prompt / terminal:
	```
	java -version
	```
	**Note: Compiling source code in Java 9 does not allow Java 8/1.8 users to run the code. They would need to re-compile it. However, Java 9 users may run Java 8/1.8 code**

## Compilation Guide

```diff
- Note: Please read the requirements section first before proceeding to any subsection
```
**Compilation instructions are similar in Windows and Linux/GNU**

1. Before proceeding, ensure that cmd prompt / terminal is opened and points to the current path of the project.
	Example:
	```
	cd ~/Downloads/comp354-pib
	```

### Compiling Existing Sources

2. To compile the code, use:
	```
	javac @sources.txt -d ./bin
	```
	This will compile the entire project into the bin folder.

### Adding Sources for Compilation

2. To add new sources to be prepared for compilation, use:
	```
	find -name "*.java" > sources.txt
	```

	or simply type the name of the new sources by appending to that file.

## Execution Guide

```diff
- Note: Please read the requirements section first before proceeding to any subsection
```
**Compilation instructions are similar in Windows and Linux/GNU**

1. Before proceeding, ensure that cmd prompt / terminal is opened and points to the current path of the project.

2. Run the terminal/cmd prompt and change current path to the bin folder (comp354-pib/bin) using the command 'cd'.

	Example:
	```
	cd ~/Downloads/comp354-pib/bin
	```

	Otherwise if the current session is already pointing to the project folder, simply type:
	```
	cd ./bin
	```

3. Run the project's main entry class:
	```
	java ui.Window
	```
