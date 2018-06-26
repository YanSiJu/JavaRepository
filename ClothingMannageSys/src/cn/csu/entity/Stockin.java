package cn.csu.entity;

import java.time.LocalDate;

public class Stockin {

	private int stockinId;
	private int wareId;
	private int userId;
	private LocalDate date;
	private String remark;
	public int getStockinId() {
		return stockinId;
	}
	public void setStockinId(int stockinId) {
		this.stockinId = stockinId;
	}
	public Stockin(int stockinId, int wareId, int userId, LocalDate date, String remark) {
		super();
		this.stockinId = stockinId;
		this.wareId = wareId;
		this.userId = userId;
		this.date = date;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Stockin [stockinId=" + stockinId + ", wareId=" + wareId + ", userId=" + userId + ", date=" + date
				+ ", remark=" + remark + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + stockinId;
		result = prime * result + userId;
		result = prime * result + wareId;
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
		Stockin other = (Stockin) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (stockinId != other.stockinId)
			return false;
		if (userId != other.userId)
			return false;
		if (wareId != other.wareId)
			return false;
		return true;
	}
	public int getWareId() {
		return wareId;
	}
	public void setWareId(int wareId) {
		this.wareId = wareId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
