Java EE 7 Petclinic
===================

JSF with Java EE 7 Version of Spring Petclinic

Running on OpenShift: http://wildfly8-javaee7petclinic.rhcloud.com/

install JBoss Wildfly
---------------------

install JBoss Wildfly 8.0.0.CR1 from http://wildfly.org/downloads/ to e.g. /Users/tw/srv/wildfly-8.0.0.CR1/

start JBoss by: cd /Users/tw/srv/wildfly-8.0.0.CR1/bin ; ./standalone.sh

build and run
-------------

git clone https://github.com/phasenraum2010/javaee7-petclinic.git

build project with: mvn clean install wildfly:deploy

open url in browser: http://localhost:8080/javaee7-petclinic-1.0-SNAPSHOT/

First Steps
-----------

add some PetTypes like dog,cat,mouse,...

add some Specialties for Vetinarians like dentist, anesthetist, radiology,...

add a Vetinarian

add an Owner, add him am a Pet and his Pet a visit.

visit Spring Petclinic
----------------------
https://github.com/spring-projects/spring-petclinic
