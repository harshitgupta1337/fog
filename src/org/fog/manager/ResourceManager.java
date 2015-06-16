package org.fog.manager;

import java.util.HashMap;
import java.util.Map;

import org.fog.entities.ResourceMonitorData;

public class ResourceManager {

	private Map<String, ResourceMonitorData> resourceMonitorDataMap;
	
	public void updateMonitoringData(ResourceMonitorData resourceMonitorData){
		resourceMonitorDataMap.put(resourceMonitorData.getId(), resourceMonitorData);
	}
	
	
	private ResourceManager(){
		this.setResourceMonitorDataMap(new HashMap<String, ResourceMonitorData>());
	}
	
	private static ResourceManager instance;
	
	public static ResourceManager getInstance(){
		if(instance == null){
			instance = new ResourceManager();
		}
		return instance;
	}
	
	public Map<String, ResourceMonitorData> getResourceMonitorDataMap() {
		return resourceMonitorDataMap;
	}

	public void setResourceMonitorDataMap(Map<String, ResourceMonitorData> resourceMonitorDataMap) {
		this.resourceMonitorDataMap = resourceMonitorDataMap;
	}
	
}
