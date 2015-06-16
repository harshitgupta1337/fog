package org.fog.entities;

import java.util.HashMap;
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
	
	
	
}
