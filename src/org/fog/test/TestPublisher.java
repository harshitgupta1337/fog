package org.fog.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.fog.utils.Utils;

public class TestPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String clientId = "induction_loop-pub";
		MqttClient client;

        try {
            client = new MqttClient(Utils.MONITORING_BROKER_URL, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            //options.setWill(client.getTopic("home/LWT"), "I'm gone :(".getBytes(), 0, false);

            client.connect(options);

            final MqttTopic topic = client.getTopic(Utils.MONITORING_TOPIC);
            
            //Publish data forever
            while (true) {

            	String message = "Hello World !!!";
            	topic.publish(new MqttMessage(message.getBytes()));
            	System.out.println("Published data. Message: " + message);
                Thread.sleep(2000);
            }
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
