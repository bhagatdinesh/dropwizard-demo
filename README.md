# dropwizard-demo

How to start the TestLatestApplication application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/comment-1.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

---

To develop new application follow steps:

Execute:
`mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.3.2`

Need to input values for following prompts:
[Values are not related to existing project]

Define value for property 'groupId': com.dkb

Define value for property 'artifactId': 

Define value for property 'version' 1.0-SNAPSHOT: : 1

Define value for property 'package' com.dkb: : com.dkb.application

[INFO] Using property: description = null

Define value for property 'name': TestLatest

[INFO] Using property: shaded = true

Confirm properties configuration:

groupId: com.dkb

artifactId: testLatest

version: 1

package: com.dkb.application

description: null

name: test dropwizard latest

shaded: true

 Y: : Y

---

Existing dropwizard example:
https://github.com/dropwizard/dropwizard/tree/master/dropwizard-example
