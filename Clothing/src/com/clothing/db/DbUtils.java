package com.clothing.db;

import java.util.List;

public class DbUtils {
	//增删改
	public static void update(String sql,Object ...objects){
		DAO.update(sql, objects);
	}
	//查
	public static <T> List<T> select(Class<T> clazz,String sql,Object ...objects){
		
		return DAO.getForList(clazz, sql, objects);
		
	}
}
