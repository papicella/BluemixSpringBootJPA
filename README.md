<h1> IBM Bluemix - Spring Boot / Spring Data JPA / Thymeleaf demo </h1>

The following demo shows how to bind to a MYSQL service from a data bound Spring Boot [Spring Data JPA]. 
This ensures you don't have to write any code to retrieve the bound data source connection details as 
spring auto configures this for you using spring cloud service connector library.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/albums-view-bluemix.png)

<h2> Steps to run locally </h2>

- Clone code as follows

```
> git clone https://github.com/papicella/BluemixSpringBootJPA.git
```

- package as shown below

```
> mvn package
```

- cd target
- Run demo prior to deploying to Cloud Foundry as follows

```
> java -jar BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
```

- Access as follows in a browser

```
http://localhost:8080/
```

<h2> Deploy to IBM Bluemix <h2>

- When deploying to IBM Bluemix you must bind the app to a MYSQL service as shown in the manifest.yml below.

```
applications:
- name: pas-albums
  memory: 512M
  instances: 1
  host: pas-albums
  domain: mybluemix.net
  path: ./target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
  buildpack: https://github.com/cloudfoundry/java-buildpack.git
  services:
    - pas-mysql
```

Note: The manifest file below assumes you have a MYSQL service named "pas-mysql"

- Example of deployment

```
[Wed Jan 07 14:20:56 papicella@:~/vmware/software/paas/bluemix/spring-data-jpa-thymeleaf/mysql ] $ cf push -f manifest.yml
Using manifest file manifest.yml

Creating app pas-albums in org pas.apicella@tpg.com.au / space dev as pas.apicella@tpg.com.au...
OK

Using route pas-albums.mybluemix.net
Binding pas-albums.mybluemix.net to pas-albums...
OK

Uploading pas-albums...
Uploading app files from: BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
Uploading 837.2K, 135 files
Done uploading
OK
Binding service pas-mysql to app pas-albums in org pas.apicella@tpg.com.au / space dev as pas.apicella@tpg.com.au...
OK

Starting app pas-albums in org pas.apicella@tpg.com.au / space dev as pas.apicella@tpg.com.au...

0 of 1 instances running, 1 starting
0 of 1 instances running, 1 starting
1 of 1 instances running

App started


OK

App pas-albums was started using this command `SERVER_PORT=$PORT $PWD/.java-buildpack/open_jdk_jre/bin/java -cp $PWD/.:$PWD/.java-buildpack/spring_auto_reconfiguration/spring_auto_reconfiguration-1.5.0_RELEASE.jar -Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh -Xmx382293K -Xms382293K -XX:MaxMetaspaceSize=64M -XX:MetaspaceSize=64M -Xss995K org.springframework.boot.loader.JarLauncher`

Showing health and status for app pas-albums in org pas.apicella@tpg.com.au / space dev as pas.apicella@tpg.com.au...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: pas-albums.mybluemix.net
last uploaded: Wed Jan 7 03:21:52 +0000 2015

     state     since                    cpu    memory         disk
#0   running   2015-01-07 02:23:13 PM   0.0%   363M of 512M   129.3M of 1G
```

IBM Bluemix Dashboard of application once pushed

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-console-albums.png)
