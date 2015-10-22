<h1> AA IBM Bluemix - Spring Boot / Spring Data JPA / Thymeleaf demo </h1>

The following demo shows how to bind to a MYSQL service from a data bound Spring Boot [Spring Data JPA]. 
This ensures you don't have to write any code to retrieve the bound data source connection details as 
spring auto configures this for you using spring cloud service connector library.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/albums-view-bluemix.png)

<a href="https://bluemix.net/deploy?repository=https://github.com/papicella/BluemixSpringBootJPA" target="_blank"><img src="http://bluemix.net/deploy/button.png" alt="Bluemix button" /></a>

<h2> Steps to run locally </h2>

- Clone code as follows

```
> git clone https://github.com/papicella/BluemixSpringBootJPA.git
```

- package as shown below

```
> mvn package
```

<h2> Deploy to IBM Bluemix </h2>

- When deploying to IBM Bluemix you must bind the app to a MYSQL service as shown in the manifest.yml below.

```
applications:
- name: pas-albums
  memory: 512M
  instances: 1
  host: pas-albums
  domain: mybluemix.net
  path: ./target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
  buildpack: java_buildpack
  services:
    - pas-mysql
```

Note: The manifest file below assumes you have a MYSQL service named "pas-mysql"

- Example of deployment

```
pasapicella@pas-macbook-pro:~/ibm/DemoProjects/spring-starter/BluemixSpringBootJPA$ cf push -f manifest-tonab.yml
Using manifest file manifest-tonab.yml

Creating app nab-springboot-mj in org james.bligh_org / space pas-ibm as pasapi@au1.ibm.com...
OK

Using route nab-springboot-mj.mybluemix.net
Binding nab-springboot-mj.mybluemix.net to nab-springboot-mj...
OK

Uploading nab-springboot-mj...
Uploading app files from: target/BluemixSpringBootJPA-0.0.1-SNAPSHOT.jar
Uploading 858.2K, 136 files
Done uploading
OK
Binding service clearbd-mysql to app nab-springboot-mj in org james.bligh_org / space pas-ibm as pasapi@au1.ibm.com...
OK

Starting app nab-springboot-mj in org james.bligh_org / space pas-ibm as pasapi@au1.ibm.com...
-----> Downloaded app package (24M)
-----> Java Buildpack Version: v3.0 | https://github.com/cloudfoundry/java-buildpack.git#3bd15e1
-----> Downloading Open Jdk JRE 1.8.0_51 from https://download.run.pivotal.io/openjdk/lucid/x86_64/openjdk-1.8.0_51.tar.gz (1.8s)
       Expanding Open Jdk JRE to .java-buildpack/open_jdk_jre (1.3s)
-----> Downloading Spring Auto Reconfiguration 1.8.0_RELEASE from https://download.run.pivotal.io/auto-reconfiguration/auto-reconfiguration-1.8.0_RELEASE.jar (0.7s)

-----> Uploading droplet (68M)

0 of 1 instances running, 1 starting
0 of 1 instances running, 1 starting
0 of 1 instances running, 1 starting
1 of 1 instances running

App started


OK

App nab-springboot-mj was started using this command `SERVER_PORT=$PORT $PWD/.java-buildpack/open_jdk_jre/bin/java -cp $PWD/.:$PWD/.java-buildpack/spring_auto_reconfiguration/spring_auto_reconfiguration-1.8.0_RELEASE.jar -Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh -Xmx382293K -Xms382293K -XX:MaxMetaspaceSize=64M -XX:MetaspaceSize=64M -Xss995K org.springframework.boot.loader.JarLauncher`

Showing health and status for app nab-springboot-mj in org james.bligh_org / space pas-ibm as pasapi@au1.ibm.com...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: nab-springboot-mj.mybluemix.net
last uploaded: Thu Aug 13 03:46:42 UTC 2015
stack: lucid64
buildpack: java_buildpack

     state     since                    cpu     memory           disk           details
#0   running   2015-08-13 01:48:25 PM   11.4%   434.7M of 512M   146.1M of 1G
```

IBM Bluemix Dashboard of application once pushed

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-console-albums.png)
