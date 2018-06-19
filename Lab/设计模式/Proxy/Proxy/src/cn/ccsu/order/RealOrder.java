package cn.ccsu.order;

public class RealOrder extends AbstractOrder {

	public RealOrder(String commodityName, int commodityNumber, String cusName) {
		super.setCommodityName(commodityName);
		super.setCommodityNumber(commodityNumber);
		super.setCutomerName(cusName);
	}

	@Override
	public boolean modifyOrder(String operName, String commodityName,
			int commodityNumber, String cusName) {
		this.setCommodityNumber(commodityNumber);
		this.setCommodityName(commodityName);
		return true;
	}

}
