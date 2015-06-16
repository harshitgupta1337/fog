package org.fog.monitoring;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.fog.utils.Utils;

public class MonitoringSubscriber {
    private MqttClient mqttClient;

    public MonitoringSubscriber(){
    	try {
            setMqttClient(new MqttClient(Utils.MONITORING_BROKER_URL, Utils.MONITORING_CLIENT_ID));
            mqttClient.setCallback(new MonitoringCallback());
            mqttClient.connect();

            mqttClient.subscribe(Utils.MONITORING_TOPIC);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

	public MqttClient getMqttClient() {
		return mqttClient;
	}

	public void setMqttClient(MqttClient mqttClient) {
		this.mqttClient = mqttClient;
	}
}
