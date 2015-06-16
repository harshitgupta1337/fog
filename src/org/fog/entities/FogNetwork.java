package org.fog.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FogNetwork {

	private static double INF = 180;
	
	private Map<String, FogDevice> nodes;
	private Map<String, NetworkLink> edges;
	
	private static FogNetwork instance;
	
	private FogNetwork(){
		this.setNodes(new HashMap<String, FogDevice>());
		this.setEdges(new HashMap<String, NetworkLink>());
		
		this.nodes.put("root", new FogDevice("root", 0, -INF, INF, -INF, INF));
	}

	public static FogNetwork getInstance(){
		if(instance == null){
			instance = new FogNetwork();
		}
		return instance;
	}
	
	public Map<String, FogDevice> getNodes() {
		return nodes;
	}

	public void setNodes(Map<String, FogDevice> nodes) {
		this.nodes = nodes;
	}

	public Map<String, NetworkLink> getEdges() {
		return edges;
	}

	public void setEdges(Map<String, NetworkLink> edges) {
		this.edges = edges;
	}
	
	public void printNetworkNetFile(){
		List<String> keys = new ArrayList<String>();
		for(String key : nodes.keySet()){
			keys.add(key);
		}
		System.out.println("*Vertices "+nodes.keySet().size());
		int i=1;
		for(String nodeId : nodes.keySet()){
			System.out.println(i+" \""+nodeId+"\"");
			i++;
		}
		
		System.out.println("*Edges");
		List<String> edgeKeys = new ArrayList<String>();
		for(String edgeKey : edges.keySet()){
			edgeKeys.add(edgeKey);
		}
		for(String edgeId : edgeKeys){
			int u = -1;
			int v = -1;
			for(i=0;i<keys.size();i++){
				if(edges.get(edgeId).getEndPointDown().equals(keys.get(i)))
					u = i+1;
				if(edges.get(edgeId).getEndPointUp().equals(keys.get(i)))
					v = i+1;
			}
			System.out.println(u+" "+v+" 1");
		}
	}
	
	
}
