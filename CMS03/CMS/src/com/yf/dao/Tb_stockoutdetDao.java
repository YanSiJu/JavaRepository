package com.yf.dao;

import java.util.List;
import com.yf.bean.StockoutdetView;
import com.yf.db.DBUtil;

public class Tb_stockoutdetDao {
	//��ѯ�������
	public List<StockoutdetView> queryAllView(int stockout_id) {
		String sql = "select * from tb_stockoutdet ts  join tb_product tp on ts.pro_id=tp.pro_id where ts.stockout_id="+stockout_id+" ORDER BY ts.stockoutdet_id ";
		System.out.println(sql);
		return DBUtil.query(sql, StockoutdetView.class);
	}
	
	
	//��ҳ��ѯ
	public List<StockoutdetView> queryAllView(int page,int pageSize,int stockout_id) {
		String sql = "select * from tb_stockoutdet ts  join tb_product tp on ts.pro_id=tp.pro_id where ts.stockout_id="+stockout_id+" ORDER BY ts.stockoutdet_id  limit "+(page-1)*pageSize+" , "+pageSize+"";
		System.out.println(sql);
		return DBUtil.query(sql, StockoutdetView.class);
	}
}
