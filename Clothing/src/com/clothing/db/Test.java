package com.clothing.db;

import java.util.List;

import com.clothing.bean.StockInDet;

public class Test {
	
	
	public static void main(String[] args) {
		//DbUtils.update("insert into tb_user(userName,userPass,realName,userSex,userMobil) values(?,?,?,?,?)","Bill Gates","Bill666666","比尔盖茨","男","18606065946");
		DbUtils.update("update tb_client set clientName = ? where clientId = ?", "王大宝",1);
		List<StockInDet> list = DbUtils.select(StockInDet.class, "select * from tb_stockindet");
		for(StockInDet sid : list){
			System.out.println(sid);
		}
	}
}
