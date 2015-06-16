package org.fog.monitoring;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.fog.entities.ResourceMonitorData;

public class MonitoringCallback implements MqttCallback {

	public MonitoringCallback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		ResourceMonitorData resourceMonitorData = getResourceMonitorData(topic, message.toString());
		
	}

	private ResourceMonitorData getResourceMonitorData(String topic, String message){
		return null;
	}
}
