package com.yf.dao;

import java.util.List;

import com.yf.bean.Tb_color;
import com.yf.db.DBUtil;

//����  Ӧ�ð���  tb_color���  ��ɾ�Ĳ�ķ���
public class Tb_colorDao {
	// tb_color�����ӷ���
	public int insert(Tb_color color) {
		String sql="insert into Tb_color(color_name) values('"+color.getColor_name()+"')";
		System.out.println(sql);
		return DBUtil.executeUpdate(sql);

	}
	
	//ɾ���ķ���
	public int delete(int id){
		String sql="delete from tb_color where color_Id="+id+""; 
		return DBUtil.executeUpdate(sql);
	}
	
	//�޸ĵķ���
	public int update(Tb_color color){
		String sql = "update  Tb_color set color_name='"+color.getColor_name()+"' where color_id="+color.getColor_id()+"";
		return DBUtil.executeUpdate(sql);
	}
	
	//��ѯ����
	public List<Tb_color>  queryAll(){
		String sql="select * from tb_color";
		return DBUtil.query(sql, Tb_color.class);
	}
	
	
	//����id���в�ѯ�ķ���
	public List<Tb_color>  queryById(int id){
		String sql="select * from tb_color where color_id="+id+"";
		return DBUtil.query(sql, Tb_color.class);
	}
	
	//����nameģ����ѯ�ķ���
	public List<Tb_color>  queryByName(String name){
		String sql="select * from tb_color where color_name like '%"+name+"%'";
		System.out.println(sql);
		return DBUtil.query(sql, Tb_color.class);
	}
}
