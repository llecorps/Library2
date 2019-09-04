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

## In case you find a bug/suggested improvement for Spring Petclinic
Our issue tracker is available here: https://github.com/spring-projects/spring-petclinic/issues


## Database configuration

In its default configuration, Petclinic uses an in-memory database (HSQLDB) which
gets populated at startup with data. A similar setup is provided for MySql in case a persistent database configuration is needed.
Note that whenever the database type is changed, the app needs to be run with a different profile: `spring.profiles.active=mysql` for MySql.

You could start MySql locally with whatever installer works for your OS, or with docker:

```
docker run -e MYSQL_ROOT_PASSWORD=petclinic -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:5.7.8
```
