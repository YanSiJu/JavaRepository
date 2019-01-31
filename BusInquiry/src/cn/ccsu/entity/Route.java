package cn.ccsu.entity;

/**
* @author Bill
* @title: Route.java
* @Package: cn.ccsu.entity
* @Description: TODO
* @date:2019年1月31日 下午12:58:16
* @version:V1.0
*/
public class Route {
	
	private int lineId;
	private int stationId;
	private int locId;
	public int getLocId() {
		return locId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lineId;
		result = prime * result + locId;
		result = prime * result + stationId;
		return result;
	}
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (lineId != other.lineId)
			return false;
		if (locId != other.locId)
			return false;
		if (stationId != other.stationId)
			return false;
		return true;
	}
	public Route(int lineId, int stationId, int locId) {
		super();
		this.lineId = lineId;
		this.stationId = stationId;
		this.locId = locId;
	}
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Route [lineId=" + lineId + ", stationId=" + stationId + ", locId=" + locId + "]";
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}

}
