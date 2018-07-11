package com.yf.test;

import java.util.List;

import com.yf.bean.ProductView;
import com.yf.dao.Tb_productDao;

public class ProductViewTest {
  public static void main(String[] args) {
	Tb_productDao dao=new Tb_productDao();
	List<ProductView> list=dao.queryProductView();
	for (ProductView productView : list) {
		System.out.println(productView.getPro_name());
		System.out.println(productView.getColor_name());
		System.out.println(productView.getSize_name());
		System.out.println(productView.getOutma_name());
	}
}
}
