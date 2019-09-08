# Biblio Java Library Application [![Build Status](https://travis-ci.com/llecorps/Library2.svg?branch=master)](https://travis-ci.com/llecorps/Library2)
Deploy this sample application to Pivotal Web Services:


## Prerequisites
The following needs to be installed before starting.
* [Git](https://git-scm.com/downloads)
* [GlassFish](https://javaee.github.io/glassfish/)
* [Tomcat](http://tomcat.apache.org/)
* [SoapUi](https://www.soapui.org/)


## Understanding the Biblio application with a few diagrams
[See the presentation here](https://github.com/llecorps/Library2/blob/master/doc/SOA%20BIBLIO.pptx)

## Bug/suggested improvement for Spring Vivlio
Our issue tracker is available here: https://github.com/llecorps/Library2/projects/1


## Database configuration

Use Docker container to build Biblio Database.
Fill correct credentials in **docker-compose.yml** :
```
environment:
  - POSTGRES_DB=DB_NAME
  - POSTGRES_USER=USER_NAME
  - POSTGRES_PASSWORD=USER_PASSWORD
```
**Launch**
```
cd docker/dev
docker-compose up
```
**Shutdown**
```
cd docker/dev
docker-compose stop
```
**Init**
```
cd docker/dev
docker-compose stop
docker-compose rm -v
docker-compose up
```


## Working with Biblio in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* Apache Maven 3.5.3
* Bootstrap 4.0.0
* Docker
* GlassFish 5.0
* PostgreSQL 10.3
* Struts2 2.5.14.1
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
```
git clone https://github.com/llecorps/Library2
```
2) Inside IntelliJ IDEA
```
File -> Import -> Maven -> Existing Maven project
```


Then either build on the command line `./mvnw generate-resources`
or right click on the `spring-petclinic` project then `Maven -> Generates sources and Update Folders`.

3) Delivery
```
unzip biblio-batch-2.0-RELEASE-archive-deploy.tar.gz
copy config.properties, db-biblio.properties
deploy biblio-service.war on glassfish server
deploy biblio-webapp.war on tomcat server
```

4) Navigate to BIBLIO

Visit [http://localhost:8080](http://localhost:8080) in your browser.

## Biblio Module

|Functionnality | Repository  |
|--------------------------|---|
|Biblio-Batch | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-batch/pom.xml) |
|Biblio-Business | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-business/pom.xml) |
|Biblio-Consumer | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-consumer/pom.xml) |
|Biblio-Module | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-model/pom.xml) |
|Biblio-Service | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-service/pom.xml) |
|Biblio-Technical | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/biblio-technical/pom.xml) |
|Biblio-Webapp | [pom.xml](https://github.com/llecorps/Library2/blob/master/biblio/pom.xml) |

## Travis configuration

Gonfigurtaion file to Continuous Integration environment [.travis.yml](https://github.com/llecorps/Library2/blob/master/.travis.yml)
