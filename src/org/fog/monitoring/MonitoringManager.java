package org.fog.monitoring;

import java.util.ArrayList;
import java.util.List;

import org.fog.entities.FogDevice;
import org.fog.entities.FogNetwork;
import org.fog.entities.NetworkLink;
import org.fog.entities.ResourceMonitorData;
import org.fog.manager.ResourceManager;

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
		ResourceManager.getInstance().updateMonitoringData(resourceMonitorData);
	}
	
	private boolean checkForExistingFogDevice(String id){
		return FogNetwork.getInstance().getNodes().containsKey(id);
	}
	
	private String addFogDeviceToNetwork(ResourceMonitorData resourceMonitorData){
		FogDevice fogDevice = FogNetwork.getInstance().getNodes().get("root");
		
		while(true){
			FogDevice dev = null;
			List<String> coveredNodesIds = new ArrayList<String>();
			for(String southLinkId : fogDevice.getSouthLinks()){
				String otherEndFogDeviceId = FogNetwork.getInstance().getEdges().get(southLinkId).getEndPointDown();
				FogDevice otherEndFogDevice = FogNetwork.getInstance().getNodes().get(otherEndFogDeviceId);
				if(newDeviceCovers(resourceMonitorData, otherEndFogDevice)){
					coveredNodesIds.add(otherEndFogDeviceId);
				}
				if(newDeviceCovered(resourceMonitorData, otherEndFogDevice)){
					dev = otherEndFogDevice;
					break;
				}
			}
			if(dev != null){
				// A CHILD OF fogDevice COVERS THE NEW DEVICE. HENCE WE HAVE TO GO FOR ANOTHER ITERATION
				fogDevice = dev;
			}else{
				if(coveredNodesIds.size()>0){
					// FEW CHILD NODES OF fogDevice ARE COVERED BY THE NEW DEVICE. HENCE, NEW DEVICE SHOULD BE A CHILD OF fogDevice
					
					FogDevice device = new FogDevice(resourceMonitorData.getId(), fogDevice.getLevel()+1, 
							resourceMonitorData.getLat_l(), resourceMonitorData.getLat_u(), 
							resourceMonitorData.getLong_l(), resourceMonitorData.getLong_u(),
							resourceMonitorData.getMaxCpu(), resourceMonitorData.getMaxMem(), resourceMonitorData.getMaxNw());
					FogNetwork.getInstance().getNodes().put(device.getId(), device);
					
					// CREATING LINK
					NetworkLink northLink = new NetworkLink(fogDevice.getId(), device.getId());
					FogNetwork.getInstance().getEdges().put(northLink.getId(), northLink);
					device.setNorthLink(northLink.getId());
					fogDevice.getSouthLinks().add(northLink.getId());
					
					for(String coveredNodeId : coveredNodesIds){
						FogDevice coveredNode = FogNetwork.getInstance().getNodes().get(coveredNodeId);
						FogNetwork.getInstance().getEdges().get(coveredNode.getNorthLink()).setEndPointUp(device.getId());
						device.getSouthLinks().add(coveredNode.getNorthLink());
					}
				}else{
					// NO CHILD NODES OF fogDevice ARE COVERED BY THE NEW DEVICE. IT HAS TO BE A SIBLING OF THE CHILD DEVICES
					FogDevice device = new FogDevice(resourceMonitorData.getId(), fogDevice.getLevel()+1, 
							resourceMonitorData.getLat_l(), resourceMonitorData.getLat_u(), 
							resourceMonitorData.getLong_l(), resourceMonitorData.getLong_u(),
							resourceMonitorData.getMaxCpu(), resourceMonitorData.getMaxMem(), resourceMonitorData.getMaxNw());
					FogNetwork.getInstance().getNodes().put(device.getId(), device);
					
					NetworkLink link = new NetworkLink(fogDevice.getId(), device.getId());
					FogNetwork.getInstance().getEdges().put(link.getId(), link);
					device.setNorthLink(link.getId());
					fogDevice.getSouthLinks().add(link.getId());
				}
				return fogDevice.getId();
			}
		}
		
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

	public static void main(String args[]){
		MonitoringManager monitoringManager = new MonitoringManager();
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("0", 10, 20, 10, 20, 0.1, 0.1, 0.1, 100, 100, 100));
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("1", 15, 16, 15, 16, 0.1, 0.1, 0.1, 100, 100, 100));
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("2", 0, 1, 0, 1, 0.1, 0.1, 0.1, 100, 100, 100));
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("3", 0, 20, 0, 20, 0.1, 0.1, 0.1, 100, 100, 100));
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("4", -10, 0, -10, 0, 0.1, 0.1, 0.1, 100, 100, 100));
		monitoringManager.addFogDeviceToNetwork(new ResourceMonitorData("5", -1, 0, -1, 0, 0.1, 0.1, 0.1, 100, 100, 100));
		FogNetwork.getInstance().printNetworkNetFile();
	}
}