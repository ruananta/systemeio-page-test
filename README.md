### The test of the web page has been completed according to the given requirements: 
https://systemeio.notion.site/Test-task-for-QA-31d75461739c4426ae21f34027386cf2

#### Manual

Step 1: Pull the Docker Image    
To get a list of all the existing images on the system, run the following command in the command prompt:

`docker images`

If you do not already have the Selenium standalone-chrome Docker image, run the following command to download a copy of the image onto the system:

`docker pull selenium/standalone-chrome`

After rerunning the command docker images, the selenium/standalone-chrome image should appear in the list.

Step 2: Running the Selenium Webdriver Docker Container    
Once you have pulled the selenium/standalone-chrome image onto the system, start the container by running the following command:

`docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome`

Step 3: Clone the Project and Build the Docker Container    
Clone the project to your local system and run the following command to build and run the Docker container:

`docker-compose up --build`

*Есть еще один вариант установки, а именно добавить в этот контейнер(через docker-compose) selenium/hub и selenium/node-chrome, тогда не нужно будет держать отдельно контейнер с selenium.*    
*В ТЗ не указано, но я бы сделал проверку: выводится ли popup(iframe) поверх других окнон? Мною замечено, что он изначально скрыт и появляется с задержкой.*


#### Docker log
```
2024-07-27 19:05:13 maven-tests-1  | [INFO] Scanning for projects...
2024-07-27 19:05:13 maven-tests-1  | [INFO] 
2024-07-27 19:05:13 maven-tests-1  | [INFO] ------------------< org.ruananta:systeme-io-web-test >------------------
2024-07-27 19:05:13 maven-tests-1  | [INFO] Building systeme-io-web-test 0.0.1-SNAPSHOT
2024-07-27 19:05:13 maven-tests-1  | [INFO] --------------------------------[ jar ]---------------------------------
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ systeme-io-web-test ---
2024-07-27 19:05:14 maven-tests-1  | [INFO] Copying 1 resource from src/main/resources to target/classes
2024-07-27 19:05:14 maven-tests-1  | [INFO] Copying 0 resource from src/main/resources to target/classes
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ systeme-io-web-test ---
2024-07-27 19:05:14 maven-tests-1  | [INFO] Nothing to compile - all classes are up to date.
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] --- maven-resources-plugin:3.3.1:testResources (default-testResources) @ systeme-io-web-test ---
2024-07-27 19:05:14 maven-tests-1  | [INFO] skip non existing resourceDirectory /app/src/test/resources
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] --- maven-compiler-plugin:3.13.0:testCompile (default-testCompile) @ systeme-io-web-test ---
2024-07-27 19:05:14 maven-tests-1  | [INFO] Nothing to compile - all classes are up to date.
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] --- maven-surefire-plugin:3.3.1:test (default-test) @ systeme-io-web-test ---
2024-07-27 19:05:14 maven-tests-1  | [INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
2024-07-27 19:05:14 maven-tests-1  | [INFO] 
2024-07-27 19:05:14 maven-tests-1  | [INFO] -------------------------------------------------------
2024-07-27 19:05:14 maven-tests-1  | [INFO]  T E S T S
2024-07-27 19:05:14 maven-tests-1  | [INFO] -------------------------------------------------------
2024-07-27 19:05:16 maven-tests-1  | [INFO] Running org.ruananta.systemeiowebtest.MakeMoneyHomePopupTest
2024-07-27 19:05:17 maven-tests-1  | 13:20:17.322 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [org.ruananta.systemeiowebtest.MakeMoneyHomePopupTest]: MakeMoneyHomePopupTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2024-07-27 19:05:17 maven-tests-1  | 13:20:17.824 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration org.ruananta.systemeiowebtest.SystemeioWebTestApplication for test class org.ruananta.systemeiowebtest.MakeMoneyHomePopupTest
2024-07-27 19:05:19 maven-tests-1  | 
2024-07-27 19:05:19 maven-tests-1  |   .   ____          _            __ _ _
2024-07-27 19:05:19 maven-tests-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
2024-07-27 19:05:19 maven-tests-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
2024-07-27 19:05:19 maven-tests-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
2024-07-27 19:05:19 maven-tests-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
2024-07-27 19:05:19 maven-tests-1  |  =========|_|==============|___/=/_/_/_/
2024-07-27 19:05:19 maven-tests-1  | 
2024-07-27 19:05:19 maven-tests-1  |  :: Spring Boot ::       (v3.4.0-SNAPSHOT)
2024-07-27 19:05:19 maven-tests-1  | 
2024-07-27 19:05:20 maven-tests-1  | 2024-07-27T13:20:20.147Z  INFO 59 --- [systeme-io-web-test] [           main] o.r.s.MakeMoneyHomePopupTest             : Starting MakeMoneyHomePopupTest using Java 17.0.2 with PID 59 (started by root in /app)
2024-07-27 19:05:20 maven-tests-1  | 2024-07-27T13:20:20.154Z  INFO 59 --- [systeme-io-web-test] [           main] o.r.s.MakeMoneyHomePopupTest             : No active profile set, falling back to 1 default profile: "default"
2024-07-27 19:05:25 maven-tests-1  | 2024-07-27T13:20:25.074Z  INFO 59 --- [systeme-io-web-test] [           main] o.r.s.MakeMoneyHomePopupTest             : Started MakeMoneyHomePopupTest in 6.429 seconds (process running for 9.915)
2024-07-27 19:05:25 maven-tests-1  | OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
2024-07-27 19:05:27 maven-tests-1  | 2024-07-27T13:20:27.698Z  INFO 59 --- [systeme-io-web-test] [           main] o.o.s.r.t.o.OpenTelemetryTracer          : Using OpenTelemetry for tracing
2024-07-27 19:05:36 maven-tests-1  | [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 19.33 s -- in org.ruananta.systemeiowebtest.MakeMoneyHomePopupTest
2024-07-27 19:05:36 maven-tests-1  | [INFO] 
2024-07-27 19:05:36 maven-tests-1  | [INFO] Results:
2024-07-27 19:05:36 maven-tests-1  | [INFO] 
2024-07-27 19:05:36 maven-tests-1  | [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
2024-07-27 19:05:36 maven-tests-1  | [INFO] 
2024-07-27 19:05:36 maven-tests-1  | [INFO] ------------------------------------------------------------------------
2024-07-27 19:05:36 maven-tests-1  | [INFO] BUILD SUCCESS
2024-07-27 19:05:36 maven-tests-1  | [INFO] ------------------------------------------------------------------------
2024-07-27 19:05:36 maven-tests-1  | [INFO] Total time:  23.426 s
2024-07-27 19:05:36 maven-tests-1  | [INFO] Finished at: 2024-07-27T13:20:36Z
2024-07-27 19:05:36 maven-tests-1  | [INFO] ------------------------------------------------------------------------
2036-01-01 00:00:00 
2001-01-01 00:00:00 xited with code 0

```
