# NWT_Tim17

## Environment setup

### Requirements:

* IntelliJ IDEA 2017.3.4 or later (or your favorite editor)
* JDK 1.8 (1.8.0_162 or later, but not Java 9)
* PostgreSQL 10.3 or later

##### Steps:

1. Connect to your local PostgreSQL server instance and execute `initialize_database.sql` from `./scripts/`
2. Open the root folder - `NWT_Tim17` from IntelliJ start dialog
3. For every project module (you will recognize them as they are prefixed with `nwt-cinema`) do the following:
    * Expand a model folder and right click mouse on the 'java' folder
    * In the context menu, select 'Mark Directory as' -> 'Sources root'
    * Right click on `pom.xml` and select 'Add as Maven project' from the context menu
4. Now you should be able to run every microservice clicking on the green run icon next to the application class name
