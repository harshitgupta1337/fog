package org.fog.entities;

public class ResourceMonitorData {
	String id;
	int level;
	double lat_l;
	double lat_u;
	double long_l;
	double long_u;
	double cpu;
	double mem;
	double nw;
	
	public ResourceMonitorData(String id, int level, double lat_l, double lat_u, double long_l, double long_u, 
			double cpu, double mem, double nw){
		this.id = id;
		this.level = level;
		this.lat_l = lat_l;
		this.lat_u = lat_u;
		this.long_l = long_l;
		this.long_u = long_u;
		this.cpu = cpu;
		this.mem = mem;
		this.nw = nw;
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

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public double getMem() {
		return mem;
	}

	public void setMem(double mem) {
		this.mem = mem;
	}

	public double getNw() {
		return nw;
	}

	public void setNw(double nw) {
		this.nw = nw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
