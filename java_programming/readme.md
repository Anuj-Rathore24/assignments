***How to run Java code using vscode***

Java classes are organized into packages which are mapped to directories in the file system. But, unlike the file system, whenever you specify a package name, you specify the whole package name -- never part of it. For example, the package name for java.awt.Button is always specified as java.awt.

For example, suppose you want the Java runtime to find a class named Cool.class in the package utility.myapp. If the path to that directory is C:\java\MyClasses\utility\myapp, you would set the class path so that it contains C:\java\MyClasses.

To run that app, you could use the following JVM command:

C:> java -classpath C:\java\MyClasses utility.myapp.Cool
    

When the app runs, the JVM uses the class path settings to find any other classes defined in the utility.myapp package that are used by the Cool class.

**Note that the entire package name is specified in the command. It is not possible, for example, to set the class path so it contains C:\java\MyClasses\utility and use the command java myapp.Cool. The class would not be found.**

(You may be wondering what defines the package name for a class. The answer is that the package name is part of the class and cannot be modified, except by recompiling the class.)