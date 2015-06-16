package org.fog.monitoring;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.fog.entities.ResourceMonitorData;

import com.google.gson.Gson;

public class MonitoringCallback implements MqttCallback {

	Gson gson;
	
	public MonitoringCallback() {
		super();
		gson = new Gson();
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
		MonitoringManager.getInstance().insertMonitoringData(resourceMonitorData);
		System.out.println("Message Arrived : "+message.toString());
	}

	private ResourceMonitorData getResourceMonitorData(String topic, String message){
		return gson.fromJson(message, ResourceMonitorData.class);
	}
}
