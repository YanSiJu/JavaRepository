package cn.csu.entity;

import java.time.LocalDate;

public class Stockout {

	private int stockoutId;
	private int userId;
	private int wareId;
	private LocalDate date;

	public int getStockoutId() {
		return stockoutId;
	}

	public Stockout() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + stockoutId;
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
		Stockout other = (Stockout) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (stockoutId != other.stockoutId)
			return false;
		if (userId != other.userId)
			return false;
		if (wareId != other.wareId)
			return false;
		return true;
	}

	public Stockout(int stockoutId, int userId, int wareId, LocalDate date) {
		super();
		this.stockoutId = stockoutId;
		this.userId = userId;
		this.wareId = wareId;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Stockout [stockoutId=" + stockoutId + ", userId=" + userId + ", wareId=" + wareId + ", date=" + date
				+ "]";
	}

	public void setStockoutId(int stockoutId) {
		this.stockoutId = stockoutId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWareId() {
		return wareId;
	}

	public void setWareId(int wareId) {
		this.wareId = wareId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
