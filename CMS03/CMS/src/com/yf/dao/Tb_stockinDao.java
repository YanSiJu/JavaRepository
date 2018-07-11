package com.yf.dao;

import java.util.List;

import com.yf.bean.StockinView;
import com.yf.db.DBUtil;

public class Tb_stockinDao {
	// 查询入库视图
	public List<StockinView> queryStockinView() {
		String sql = "select * from tb_stockin ts join tb_warehouse tw on ts.ware_id=tw.wareId join tb_user tu on ts.userId=tu.userId order by ts.stockinId";
		System.out.println(sql);
		return DBUtil.query(sql, StockinView.class);
	}

	// 分页查询入库视图
	public List<StockinView> queryStockinView(int page, int pageSize) {
		String sql = "select * from tb_stockin ts join tb_warehouse tw on ts.wareId=tw.wareId join tb_user tu on ts.userId=tu.userId order by ts.stockinId limit "
				+ (page - 1) * pageSize + "," + pageSize + "";
		System.out.println(sql);
		return DBUtil.query(sql, StockinView.class);
	}
}
