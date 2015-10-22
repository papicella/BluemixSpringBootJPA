<h1> IBM Bluemix - Spring Boot / Spring Data JPA / Thymeleaf demo </h1>

The following demo shows how to bind to a MYSQL service from a data bound Spring Boot [Spring Data JPA]. 
This ensures you don't have to write any code to retrieve the bound data source connection details as 
spring auto configures this for you using spring cloud service connector library.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/albums-view-bluemix.png)

You can deploy this application automatically to your Bluemix Account using the button below, or you can follow the steps below.

<a href="https://bluemix.net/deploy?repository=https://github.com/papicella/BluemixSpringBootJPA" target="_blank"><img src="http://bluemix.net/deploy/button.png" alt="Bluemix button" /></a>

<h2> Steps to Run locally </h2>

- Clone code as follows

```
> git clone https://github.com/papicella/BluemixSpringBootJPA.git
```

- Edit the file src/main/resources/spring-cloud-bootstrap.properties

Here you need to specify the path to your local "spring-cloud-mysql.properties", you will need to create that file 
with content as follows. The location can be anywhere on your file system and any file name.

```
spring.cloud.propertiesFile: /Users/pasapicella/springboot/spring-cloud-mysql.properties
```

3.2. Edit the file to ensure you add your local MYSQL details, if your using the default MYSQL settings on your laptop or desktop below is all you need

```
spring.cloud.appId: SpringBootMYSQLLocal
spring.cloud.database: mysql://pas:pas@localhost:3306/test
spring.datasource.max-active: 10
spring.datasource.initial-size: 1
```
 
- package as shown below

```
> mvn package
```

- Run as follows

```
mvn spring-boot:run
```

- Access as follows

```
http://localhost:8080/
```

<h2> Deploy to IBM Bluemix </h2>

- When deploying to IBM Bluemix you must bind the app to a MYSQL service as shown in the manifest.yml below.

```
applications:
- name: pas-mjalbums
  memory: 512M
  instances: 1
  host: pas-mjalbums
  path: ./target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
  services:
    - pas-mysql
```

Note: The manifest file below assumes you have a MYSQL service named "pas-mysql", so you will need a MYSQL service
created and make sure you use the service name correctly

- Example of deployment

```
pasapicella@pas-macbook-pro:~/ibm/DemoProjects/spring-starter/BluemixSpringBootJPA$ cf push -f manifest-devspace.yml
Using manifest file manifest-devspace.yml

Creating app pas-mjalbums in org pasapi@au1.ibm.com / space dev as pasapi@au1.ibm.com...
OK

Using route pas-mjalbums.mybluemix.net
Binding pas-mjalbums.mybluemix.net to pas-mjalbums...
OK

Uploading pas-mjalbums...
Uploading app files from: target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
Uploading 784K, 137 files
Done uploading
OK
Binding service pas-mysql to app pas-mjalbums in org pasapi@au1.ibm.com / space dev as pasapi@au1.ibm.com...
OK

Starting app pas-mjalbums in org pasapi@au1.ibm.com / space dev as pasapi@au1.ibm.com...
-----> Downloaded app package (30M)
-----> Liberty Buildpack Version: v2.1-20151006-0912
-----> Retrieving IBM 1.8.0_20150828 JRE (ibm-java-jre-8.0-1.11-pxa6480sr1fp11-20150828_01-cloud.tgz) ... (0.0s)
         Expanding JRE to .java ... (0.9s)
-----> Retrieving App Management 1.12.0_20151001-1521 (app-mgmt_v1.12-20151001-1521.zip) ... (0.0s)
         Expanding App Management to .app-management (0.1s)
-----> Downloading Auto Reconfiguration 1.10.0_RELEASE from https://download.run.pivotal.io/auto-reconfiguration/auto-reconfiguration-1.10.0_RELEASE.jar (2.4s)
-----> Liberty buildpack is done creating the droplet

-----> Uploading droplet (89M)

0 of 1 instances running, 1 starting
1 of 1 instances running

App started


OK

App pas-mjalbums was started using this command `$PWD/.java/jre/bin/java -Xtune:virtualized -Xmx384M -Xdump:none -Xdump:heap:defaults:file=./../dumps/heapdump.%Y%m%d.%H%M%S.%pid.%seq.phd -Xdump:java:defaults:file=./../dumps/javacore.%Y%m%d.%H%M%S.%pid.%seq.txt -Xdump:snap:defaults:file=./../dumps/Snap.%Y%m%d.%H%M%S.%pid.%seq.trc -Xdump:heap+java+snap:events=user -Xshareclasses:none -Xdump:tool:events=systhrow,filter=java/lang/OutOfMemoryError,request=serial+exclusive,exec=./.buildpack-diagnostics/killjava.sh $JVM_ARGS org.springframework.boot.loader.JarLauncher --server.port=$PORT`

Showing health and status for app pas-mjalbums in org pasapi@au1.ibm.com / space dev as pasapi@au1.ibm.com...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: pas-mjalbums.mybluemix.net
last uploaded: Thu Oct 22 17:32:22 UTC 2015
stack: cflinuxfs2
buildpack: Liberty for Java(TM) (JAR, java-main, ibmjdk-1.8.0_20150828, env, spring-auto-reconfiguration-1.10.0_RELEASE)

     state     since                    cpu    memory           disk           details
#0   running   2015-10-22 01:34:14 PM   0.3%   198.6M of 512M   128.4M of 1G
```

IBM Bluemix Dashboard of application once pushed

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-console-albums.png)
