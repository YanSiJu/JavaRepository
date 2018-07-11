package com.yf.dao;

import java.util.List;

import com.yf.bean.StockindetView;
import com.yf.db.DBUtil;

public class Tb_stockindetDao {
	//≤È—Ø»Îø‚œÍœ∏ ”Õº
   public List<StockindetView> queryStockinView(int stock_id){
	   String sql="select * from tb_stockindet ts join tb_product tp on ts.pro_id=tp.pro_id where stockin_id="+stock_id+" order by ts.stockindet_id";
	   System.out.println(sql);
	   return DBUtil.query(sql, StockindetView.class);
   }
   
}
