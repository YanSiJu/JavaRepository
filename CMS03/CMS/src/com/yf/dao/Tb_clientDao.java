package com.yf.dao;

import java.util.List;

import com.yf.bean.Tb_client;
import com.yf.db.DBUtil;

//����tb_client�����ɾ�Ĳ�ķ���
public class Tb_clientDao {
	//��ӵķ���
	public int insert(Tb_client tc) {
		String sql = "insert into tb_client(client_name,client_phone,client_address)";
		sql = sql + " values('"+tc.getClient_name()+"','"+tc.getClient_phone()+"','"+tc.getClient_address()+"')";
		return DBUtil.executeUpdate(sql);

	}
	
	//ɾ���ķ���
	public int delete(int id){
		String sql="delete from tb_client where cilent_id="+id+""; 
		return DBUtil.executeUpdate(sql);
	}
	
	//�޸ĵķ���
	public int update(Tb_client tc){
		String sql = "update  tb_client set client_name='"+tc.getClient_name()+"',client_phone='"+tc.getClient_phone()+"',client_address='"+tc.getClient_address()+"' where client_Id="+tc.getClient_id()+"";
		return DBUtil.executeUpdate(sql);
	}
	
	//��ѯ����
	public List<Tb_client>  queryAll(){
		String sql="select * from tb_client";
		return DBUtil.query(sql, Tb_client.class);
	}
}
