package org.fog.manager;

import org.fog.monitoring.MonitoringSubscriber;

public class Runner {
	private MonitoringSubscriber monitoringSubscriber;
	
	public Runner(){
		this.setMonitoringSubscriber(new MonitoringSubscriber());
	}

	public MonitoringSubscriber getMonitoringSubscriber() {
		return monitoringSubscriber;
	}

	public void setMonitoringSubscriber(MonitoringSubscriber monitoringManager) {
		this.monitoringSubscriber = monitoringManager;
	}

	public static void main(String args[]){
		
	}
}
