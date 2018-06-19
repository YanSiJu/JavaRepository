package cn.ccsu.order;

public abstract class AbstractOrder {

	private String cutomerName;
	private int commodityNumber;
	private String commodityName;

	public String getCutomerName() {
		return cutomerName;
	}

	public abstract boolean modifyOrder(String operName, String commodityName,
			int commodityNumber,String cusName);

	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}

	public int getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

}
