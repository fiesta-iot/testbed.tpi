# testbed.tpi
This repository provides components related to the FIESTA-IoT testbed side

## Install & Run

The prototype has been implemented as a Maven-based web application. Below WILDFLY_HOME indicates the root directory of the WildFly distribution, and PROJECT_HOME indicates the root directory of the project (tpi.api.tps).

In order to build the prototype, run the following command in PROJECT_HOME:

```
mvn clean package
```

Finally, in order to deploy the prototype, run the following command in PROJECT_HOME:

```
mvn wildfly:deploy
```

The last step assumes that WildFly is already running on the machine where you run the command.

The produced, from the build process above (mvn clean package), project can be found within PROJECT_HOME/target/ folder and is the tpi.api.tps.war file. Alternatively copy the produced (from the build process above) tpi.api.tps.war file from the target directory (PROJECT_HOME/target/), into the WILDFLY_HOME/standalone/deployments directory of the WildFly distribution, in order to be automatically deployed.

If the deployment has been successfully completed, the implemented web services described in the section above will be exposed under the following URLs:

- http://[HOST]:[PORT]/tpi.api.tps/rest/tps/getLastObservations
- http://[HOST]:[PORT]/tpi.api.tps/rest/tps/getObservations
- http://[HOST]:[PORT]/tpi.api.tps/rest/tps/pushLastObservations
- http://[HOST]:[PORT]/tpi.api.tps/rest/tps/stopPushOfObservations

where [HOST] is the host and [PORT] the port that WildFly uses.
