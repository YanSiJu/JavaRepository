package com.yf.dao;

import java.util.List;

import com.yf.bean.Tb_color;
import com.yf.db.DBUtil;

//此类  应该包含  tb_color表的  增删改查的方法
public class Tb_colorDao {
	// tb_color表的添加方法
	public int insert(Tb_color color) {
		String sql="insert into Tb_color(color_name) values('"+color.getColor_name()+"')";
		System.out.println(sql);
		return DBUtil.executeUpdate(sql);

	}
	
	//删除的方法
	public int delete(int id){
		String sql="delete from tb_color where color_Id="+id+""; 
		return DBUtil.executeUpdate(sql);
	}
	
	//修改的方法
	public int update(Tb_color color){
		String sql = "update  Tb_color set color_name='"+color.getColor_name()+"' where color_id="+color.getColor_id()+"";
		return DBUtil.executeUpdate(sql);
	}
	
	//查询方法
	public List<Tb_color>  queryAll(){
		String sql="select * from tb_color";
		return DBUtil.query(sql, Tb_color.class);
	}
	
	
	//根据id进行查询的方法
	public List<Tb_color>  queryById(int id){
		String sql="select * from tb_color where color_id="+id+"";
		return DBUtil.query(sql, Tb_color.class);
	}
	
	//根据name模糊查询的方法
	public List<Tb_color>  queryByName(String name){
		String sql="select * from tb_color where color_name like '%"+name+"%'";
		System.out.println(sql);
		return DBUtil.query(sql, Tb_color.class);
	}
}
