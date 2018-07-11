package com.yf.dao;

import java.util.List;

import com.yf.bean.ProductView;
import com.yf.db.DBUtil;

public class Tb_productDao {
	//查询商品视图
	public List<ProductView>  queryProductView(){
		String sql="select * from tb_product tp join tb_color tc on tp.color_id=tc.color_id join tb_size ts on tp.size_id=ts.size_id join tb_outma tout on tp.outma_id=tout.outma_id order by tp.pro_id";
		System.out.println(sql);
		return DBUtil.query(sql, ProductView.class);
	}
	
	    //分页查询商品视图
		public List<ProductView>  queryProductView(int page,int pageSize){
			String sql="select * from tb_product tp join tb_color tc on tp.color_id=tc.color_id join tb_size ts on tp.size_id=ts.size_id join tb_outma tout on tp.outma_id=tout.outma_id order by tp.pro_id limit "+(page-1)*pageSize+","+pageSize+"";
			System.out.println(sql);
			return DBUtil.query(sql, ProductView.class);
		}
}
