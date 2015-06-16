package org.fog.monitoring;

public class MonitoringManager {
	
	private static MonitoringManager instance;
	
	public static MonitoringManager getInstance(){
		if(instance == null){
			instance = new MonitoringManager();
		}
		return instance;
	}

}
