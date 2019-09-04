# Biblio Java Library Application [![Build Status](https://travis-ci.com/llecorps/Library2.svg?branch=master)](https://travis-ci.com/llecorps/Library2)
Deploy this sample application to Pivotal Web Services:


## Prerequisites
The following needs to be installed before starting.
* [Git](https://git-scm.com/downloads)
* [Git-LFS](https://git-lfs.github.com/)
* [VirtualBox](https://www.virtualbox.org/wiki/Downloads)
* [Vagrant](https://www.vagrantup.com/downloads.html)
* [vagrant-vbguest](https://github.com/dotless-de/vagrant-vbguest)


## Understanding the Biblio application with a few diagrams
<a href="https://speakerdeck.com/">See the presentation here</a>

## Running petclinic locally
Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/spring-projects/spring-petclinic.git
cd spring-petclinic
./mvnw package
java -jar target/*.jar
```

You can then access petclinic here: http://localhost:8080/

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">
