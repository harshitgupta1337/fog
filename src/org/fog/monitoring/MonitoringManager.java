package org.fog.monitoring;

import org.fog.entities.FogDevice;
import org.fog.entities.FogNetwork;
import org.fog.entities.ResourceMonitorData;

public class MonitoringManager {
	
	private static MonitoringManager instance;
	
	public static MonitoringManager getInstance(){
		if(instance == null){
			instance = new MonitoringManager();
		}
		return instance;
	}
	
	public void insertMonitoringData(ResourceMonitorData resourceMonitorData){
		if(!checkForExistingFogDevice(resourceMonitorData.getId())){
			addFogDeviceToNetwork(resourceMonitorData);
		}
	}
	
	private boolean checkForExistingFogDevice(String id){
		return FogNetwork.getInstance().getNodes().containsKey(id);
	}
	
	private void addFogDeviceToNetwork(ResourceMonitorData resourceMonitorData){
		FogDevice fogDevice = FogNetwork.getInstance().getNodes().get("root");
		
		
	}
	
	private boolean newDeviceCovered(ResourceMonitorData resourceMonitorData, FogDevice fogDevice){
		if(fogDevice.getLat_l() <= resourceMonitorData.getLat_l() && fogDevice.getLat_u() >= resourceMonitorData.getLat_u() && fogDevice.getLong_l() <= resourceMonitorData.getLong_l() && fogDevice.getLong_u() >= resourceMonitorData.getLong_u())
			return true;
		return false;
	}
	
	private boolean newDeviceCovers(ResourceMonitorData resourceMonitorData, FogDevice fogDevice){
		if(fogDevice.getLat_l() >= resourceMonitorData.getLat_l() && fogDevice.getLat_u() <= resourceMonitorData.getLat_u() && fogDevice.getLong_l() >= resourceMonitorData.getLong_l() && fogDevice.getLong_u() <= resourceMonitorData.getLong_u())
			return true;
		return false;
	}

}
