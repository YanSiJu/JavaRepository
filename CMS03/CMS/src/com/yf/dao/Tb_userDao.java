package com.yf.dao;

import java.util.List;

import com.yf.bean.Tb_user;
import com.yf.db.DBUtil;

//����  Ӧ�ð���  tb_user���  ��ɾ�Ĳ�ķ���
public class Tb_userDao {
	// tb_user�����ӷ���
	public int insert(Tb_user tu) {
		String sql = "insert into tb_user(user_name,user_pass,real_name,user_sex,user_mobil)";
		sql = sql + " values('" + tu.getUser_name() + "','" + tu.getUser_pass()
				+ "','" + tu.getReal_name() + "','" + tu.getUser_sex() + "','"
				+ tu.getUser_mobil() + "')";
		return DBUtil.executeUpdate(sql);

	}
	
	//ɾ���ķ���
	public int delete(int id){
		String sql="delete from tb_user where user_Id="+id+""; 
		return DBUtil.executeUpdate(sql);
	}
	
	//�޸ĵķ���
	public int update(Tb_user tu){
		String sql = "update  tb_user set user_name='"+tu.getUser_name()+"', user_pass='"+tu.getUser_pass()+"',real_name='"+tu.getReal_name()+"',user_sex='"+tu.getUser_sex()+"',user_mobil='"+tu.getUser_mobil()+"' where user_id="+tu.getUser_id()+"";
		return DBUtil.executeUpdate(sql);
	}
	
	//��ѯ����
	public List<Tb_user>  queryAll(){
		String sql="select * from tb_user";
		return DBUtil.query(sql, Tb_user.class);
	}
}
