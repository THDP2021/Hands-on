Welcome to JAVA - JDBC hands-on practice

First of all, you need the mysql connector jar, in this example it is located in "src/com/database/jars",
in order to use the java classes in the connector, you need to link the jar to the project,
double-click on the project and go "Settings/Libraries", also you need an MYSQL instance, for this example,
we have a free cloud MYSQL instance and a generated database name, user and password.

For connect your cloud database you need this information:

>server url: example -> db4free.net
>server port: example -> 3306 (MYSQL default)
>database name: example -> thd_ho_test
>username: example -> thd_ho_test
>password: example -> h4nd50n3

It does not matter if the database is empty, you can always reset the database information with
the script we have prepared for this hands-on. It is located on "src/com/database/scripts" and
the filename is "Init.sql".

Once you have your environment correctly configured, you can run Database.java to test the correct functionality.
If there is any problem please check the instructions or Google it. When you pass the test on Database.java,
please complete the exercises on "examples" folder or complete this goal:
TODO: Complete all the TODO exercises under the "examples" folder, check Database.java or "repositories/ProductRepository" for guidance.

FunctionsExample.java, MapperExample.java and ProceduresExample.java are very examples of how to use the
connection class, feel free of use them as you want or create other functions or methods to experiment with them.