package org.fog.manager;

import org.fog.monitoring.MonitoringSubscriber;

public class Runner {
	private ResourceManager resourceManager;
	private MonitoringSubscriber monitoringSubscriber;
	
	public Runner(){
		this.setResourceManager(new ResourceManager());
		this.setMonitoringSubscriber(new MonitoringSubscriber());
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	public MonitoringSubscriber getMonitoringSubscriber() {
		return monitoringSubscriber;
	}

	public void setMonitoringSubscriber(MonitoringSubscriber monitoringManager) {
		this.monitoringSubscriber = monitoringManager;
	}

}
