package org.fog.entities;

public class NetworkLink {
	private String id;
	private String endPointUp;
	private String endPointDown;
	
	
	public NetworkLink(String id, String endPointUp, String endPointDown){
		this.id = id;
		this.endPointUp = endPointUp;
		this.endPointDown = endPointDown;
	}
	public NetworkLink(String endPointUp, String endPointDown){
		this.id = endPointDown+"-->"+endPointUp;
		this.endPointUp = endPointUp;
		this.endPointDown = endPointDown;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEndPointUp() {
		return endPointUp;
	}
	public void setEndPointUp(String endPointUp) {
		this.endPointUp = endPointUp;
	}
	public String getEndPointDown() {
		return endPointDown;
	}
	public void setEndPointDown(String endPointDown) {
		this.endPointDown = endPointDown;
	}
}
