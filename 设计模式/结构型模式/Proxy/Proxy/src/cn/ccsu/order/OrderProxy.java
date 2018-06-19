package cn.ccsu.order;

public class OrderProxy extends AbstractOrder {

	RealOrder order;

	public OrderProxy(String commodityName, int commodityNumber, String cusName) {
		
		order = new RealOrder(commodityName, commodityNumber, cusName);
	}

	@Override
	public boolean modifyOrder(String operName, String commodityName,
			int commodityNumber, String cusName) {

		if (operName != null && operName.equals(cusName)) {

			System.out.println(operName + "修改成功修改后的订单信息：商品名称-->"
					+ commodityName + ",商品数量-->" + commodityNumber);
			return true;

		} else {
			System.out.println("对不起" + operName + "无权修改商品名称");
			return false;
		}

	}
}
