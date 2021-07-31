# Java-Spring-PostgreSQL-CRUD

### Create project
go to [link](https://start.spring.io/)
* Group
* Artifact (name of app)
* Name of main class

### launch your ide
```sh
idea . # or
code-insiders .
http://localhost:8080/v3/api-docs/ # endpoint of openapi or set custom in .properties
springdoc.api-docs.path=/api-docs

```

### Init database in docker container
```sh
docker container ls # and copy the container id
docker exec -it {container_id} /bin/bash

psql -u root # connect to postgres
\l # list all tables
DROP DATABASE IF EXISTS app;  # don't forget to put `;`
CREATE DATABASE app; # don't forget to put `;`
\q # to exit
```

### Commands
```sh
mvn install # reload pom.xml
```