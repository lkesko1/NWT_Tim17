# NWT_Tim17

## Environment setup

### Requirements:

* IntelliJ IDEA 2017.3.4 or later (or your favorite editor)
* JDK 1.8 (1.8.0_162 or later, but not Java 9)
* PostgreSQL 10.3 or later - It would be great if you could set a listen port to 5433
* RabbitMQ 3.7 Server running on its default port and being accessible using default credentials

##### Steps:

1. Connect to your local PostgreSQL server instance and execute `initialize_database.sql` from `./scripts/`
2. Open the root folder - `NWT_Tim17` from IntelliJ start dialog
3. For every project module (you will recognize them as they are prefixed with `nwt-cinema`) do the following:
    * Right click on `pom.xml` and select 'Add as Maven project' from the context menu
4. If your PostgreSQL server instance have set a listen port to 5432, then you should change `application.properties` to update `server.port` variable to 5432 for every module
5. Now you should be able to run every microservice clicking on the green run icon next to the application class name

#### Docker start:
1. install docker
2. In each project create jar file by executing the following command: 
   * mvn clean package -Dmaven.test.skip=true
3. From main folder start docker: 
   * docker-compose build && docker-compose up
