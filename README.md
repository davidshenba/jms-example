JMS Example
===========

A sample project using Spring Boot, JMS (Active MQ) to demonstrate synchronous JMS listener for REST API using Correlation ID  

How to run?
-----------

You need MariaDB and ActiveMQ installed. (All default configurations except Database, username and password.) You have to insert few dummy transactions (as there is no exposed API for insert as of now)

Check-out this project in your local, and set it up in Eclipse (or any other IDE of your choice, or no IDE at all!). You should have Maven plug-in installed in your IDE or you should have Maven installed in your machine in case of no IDE.

Run Maven install in your IDE or "mvn install" in command prompt from the location where the pom.xml resides.

Now, in your IDE, set Maven build goal to "spring-boot:run" and run it as Maven Build. Else, from command prompt, run "mvn spring-boot:run"

Open a browser of your choice and hit "http://localhost:8080/transactions"