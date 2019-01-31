package cn.ccsu.entity;

/**
* @author Bill
* @title: Line.java
* @Package: cn.ccsu.entity
* @Description: TODO
* @date:2019年1月31日 下午12:51:17
* @version:V1.0
*/
public class Line {
	
	private int lineId;
	//线路名称
	private String name;
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lineId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stationNum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (lineId != other.lineId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stationNum != other.stationNum)
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStationNum() {
		return stationNum;
	}
	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	//站点数
	private int stationNum;
	public Line(int lineId, String name, int stationNum) {
		super();
		this.lineId = lineId;
		this.name = name;
		this.stationNum = stationNum;
	}
	public Line() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Line [lineId=" + lineId + ", name=" + name + ", stationNum=" + stationNum + "]";
	}

}
