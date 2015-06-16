package org.fog.entities;

public class ResourceMonitorData {
	private String id;
	private double lat_l;
	private double lat_u;
	private double long_l;
	private double long_u;
	private double cpu;
	private double mem;
	private double nw;
	private double maxCpu;
	private double maxMem;
	private double maxNw;
	
	public ResourceMonitorData(String id, double lat_l, double lat_u, double long_l, double long_u, 
			double cpu, double mem, double nw, double maxCpu, double maxMem, double maxNw){
		this.id = id;
		this.lat_l = lat_l;
		this.lat_u = lat_u;
		this.long_l = long_l;
		this.long_u = long_u;
		this.cpu = cpu;
		this.mem = mem;
		this.nw = nw;
		this.maxCpu = maxCpu;
		this.maxMem = maxMem;
		this.maxNw = maxNw;
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


	public double getMaxCpu() {
		return maxCpu;
	}


	public void setMaxCpu(double maxCpu) {
		this.maxCpu = maxCpu;
	}


	public double getMaxMem() {
		return maxMem;
	}


	public void setMaxMem(double maxMem) {
		this.maxMem = maxMem;
	}


	public double getMaxNw() {
		return maxNw;
	}


	public void setMaxNw(double maxNw) {
		this.maxNw = maxNw;
	}

}
