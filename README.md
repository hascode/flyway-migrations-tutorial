# Flyway DB Migrations Tutorial

Examples for using the Flyway framework, a Singleton EJB and lifecycle annotations to implement database migrations on application startup in a Java EE 6 environment and using an embedded GlassFish.

Please feel free to take a look at my blog at [www.hascode.com] for the full tutorial.

## Running the examples

* Clone the project using **git clone https://bitbucket.org/hascode/flyway-migrations-tutorial.git**

* Change into the directory flyway-migrations-tutorial and start the embedded GlassFish and the Flyway migrations running **mvn** (default goal in the pom.xml is configured to run mvn clean package embedded-glassfish:run)

* Open **http://localhost:8080/flyway-tutorial/books** in your browser .. you should see some output with four books ..

----

   [www.hascode.com]:http://www.hascode.com/

**2013 Micha Kops / hasCode.com**