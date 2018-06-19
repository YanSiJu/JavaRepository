package cn.ccsu.entity;

/**
 * @author Bill
 *
 */
public class SalesmanMonthlyRecord implements Comparable<SalesmanMonthlyRecord> {

	// 销售员编号
	private Integer id;
	// 月销售总额
	private Double monthlySaleroom;
	// 销售员姓名
	private String name;
	private String month;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((monthlySaleroom == null) ? 0 : monthlySaleroom.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SalesmanMonthlyRecord other = (SalesmanMonthlyRecord) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (month == null) {
			if (other.month != null) {
				return false;
			}
		} else if (!month.equals(other.month)) {
			return false;
		}
		if (monthlySaleroom == null) {
			if (other.monthlySaleroom != null) {
				return false;
			}
		} else if (!monthlySaleroom.equals(other.monthlySaleroom)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public SalesmanMonthlyRecord() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	public SalesmanMonthlyRecord(Integer id, Double monthlySaleroom, String name, String month) {
		super();
		this.id = id;
		this.monthlySaleroom = monthlySaleroom;
		this.name = name;
		this.month = month;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesmanMonthlyRecord [id=" + id + ", monthlySaleroom=" + monthlySaleroom + ", name=" + name
				+ ", month=" + month + "]";
	}

	/**
	 * @return the monthlySaleroom
	 */
	public Double getMonthlySaleroom() {
		return monthlySaleroom;
	}

	/**
	 * @param monthlySaleroom
	 *            the monthlySaleroom to set
	 */
	public void setMonthlySaleroom(Double monthlySaleroom) {
		this.monthlySaleroom = monthlySaleroom;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int compareTo(SalesmanMonthlyRecord o) {
		return -this.getMonthlySaleroom().compareTo(o.getMonthlySaleroom());
	}

}
