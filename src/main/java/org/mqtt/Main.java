package org.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Main {
    public static void main(String[] args) {
        var topic = "mqtt-topic";
        var content = "New message from mqtt-publish-sample";
        var qos = 2;
        var broker = "tcp://127.0.0.1:1883";
        var publisherId = "mqtt-publisher";
        var persistence = new MemoryPersistence();

        try {
            var mqttPublisher = new MqttClient(broker, publisherId, persistence);
            var connOpts = new MqttConnectOptions();

            connOpts.setCleanSession(true);
            connOpts.setAutomaticReconnect(true);
            connOpts.setConnectionTimeout(10);

            System.out.println("Connecting to broker: " + broker);
            mqttPublisher.connect(connOpts);
            System.out.println("Connected");

            System.out.println("Publishing message: " + content);
            var message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            mqttPublisher.publish(topic, message);
            System.out.println("Message published");

            mqttPublisher.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (MqttException e) {
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Error cause: " + e.getCause());
            e.printStackTrace();
        }
    }
}