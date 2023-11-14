# MQTT Basics

This project is intended to show the basic usage of Mosquitto, 
an Eclipse Message Broker, through Docker and Java.

I also created a RMI Client and Server example, due to a college work (distributed systems) which I will have
to integrate this two resources.


## Installation

These are some of the tools you're going to need in order to run this project:

```
  maven
  docker
  java 11
  docker-compose (or docker compose)
```
    

## Usage

This command will run the mqtt-broker + mqtt-sub + mqtt-pub. 
The terminal will be attached with the docker compose logs, 
and mqtt-sub will log every message that comes into mqtt-topic.   
```
docker compose up --build
```
After that, you might want to see everything working. 
Just run this command in another terminal to publish a message into mqtt-topic defined into docker-compose.yaml.
```
docker compose run mqtt-pub sh -c "mosquitto_pub -h mqtt-broker -t mqtt-topic -m 'Hello World'"
```
It basically runs a container with the command inside the commas.
You should see the message "Hello World" in the terminal where you ran the first docker compose command.

To publish a message into mqtt-topic from this Java project, you just have to open it inside your IDE, 
run maven dependencies and then run the project.


## Support

If you have any questions, feel free to email me at cristianeduardo.dev@gmail.com.


## Contributions

If you have any contributions to make, feel free to open an issue or PR.


## References

 - [MQTT Broker with Docker](https://dev.to/abbazs/a-step-by-step-guide-for-starting-a-mosquitto-broker-service-in-a-containers-with-docker-compose-1j8i)
 - [MQTT Client in Java](https://www.baeldung.com/java-mqtt-client)
 - [RMI Example in Java](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/hello/hello-world.html#create)

## License

[MIT](https://choosealicense.com/licenses/mit/)
