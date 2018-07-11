package com.yf.dao;

import java.util.List;

import com.yf.bean.StockoutView;
import com.yf.db.DBUtil;

public class Tb_stockoutDao {
	   //²éÑ¯³ö¿â
		public List<StockoutView> queryAllView(int page,int pageSize) {
			String sql = "select * from tb_stockout ts join tb_user tu on ts.user_id=tu.user_id join tb_client tc on ts.client_id=tc.client_id join tb_warehouse tw on ts.ware_id=tw.ware_id order by ts.stockout_id limit "+(page-1)*pageSize+" , "+pageSize+"";
			System.out.println(sql);
			return DBUtil.query(sql, StockoutView.class);
		}
		
		public List<StockoutView> queryAllView() {
			String sql = "select * from tb_stockout ts join tb_user tu on ts.user_id=tu.user_id join tb_client tc on ts.client_id=tc.client_id join tb_warehouse tw on ts.ware_id=tw.ware_id order by ts.stockout_id";
			System.out.println(sql);
			return DBUtil.query(sql, StockoutView.class);
		}
}
