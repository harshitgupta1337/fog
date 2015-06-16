package org.fog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FogDevice {
	
	private String id;
	private int level;
	private double lat_l;
	private double lat_u;
	private double long_l;
	private double long_u;
	private List<String> incomingLinks;
	private String outgoingLink;
	
	public FogDevice(String id, int level, double lat_l, double lat_u, double long_l, double long_u){
		this.id = id;
		this.level = level;
		this.lat_l = lat_l;
		this.lat_u = lat_u;
		this.long_l = long_l;
		this.long_u = long_u;
		this.setIncomingLinks(new ArrayList<String>());
	}
	
	public FogDevice(int level, double lat_l, double lat_u, double long_l, double long_u){
		this.id = UUID.randomUUID().toString();
		this.level = level;
		this.lat_l = lat_l;
		this.lat_u = lat_u;
		this.long_l = long_l;
		this.long_u = long_u;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getLat_l() {
		return lat_l;
	}
	public void setLat_l(double lat_l) {
		this.lat_l = lat_l;
	}
	public double getLat_u() {
		return lat_u;
	}
	public void setLat_u(double lat_u) {
		this.lat_u = lat_u;
	}
	public double getLong_l() {
		return long_l;
	}
	public void setLong_l(double long_l) {
		this.long_l = long_l;
	}
	public double getLong_u() {
		return long_u;
	}
	public void setLong_u(double long_u) {
		this.long_u = long_u;
	}

	public String getOutgoingLink() {
		return outgoingLink;
	}

	public void setOutgoingLink(String outgoingLink) {
		this.outgoingLink = outgoingLink;
	}

	public List<String> getIncomingLinks() {
		return incomingLinks;
	}

	public void setIncomingLinks(List<String> incomingLinks) {
		this.incomingLinks = incomingLinks;
	}
}
