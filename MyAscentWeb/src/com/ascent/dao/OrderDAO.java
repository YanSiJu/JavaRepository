package com.ascent.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.ascent.util.CartItem;
import com.ascent.util.DataAccess;
import com.ascent.util.DataAccessJDBC;

import com.ascent.bean.*;

/**
 * �Զ������󣬼���������в�������
 * @author zy
 */
public class OrderDAO {

	/**
	 * ���涩������
	 * @param con �������
	 * @param pu ���������û�
	 * @return �ʼ�����
	 * @throws SQLException
	 */
	public String saveOrder(Collection<CartItem> con, Usr pu) throws SQLException {

		Connection conn = DataAccess.getConnection();
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		String content = "";// �ʼ�����
		
		try {
			conn.setAutoCommit(false);
			int uid = pu.getId();
			if (uid == 0){ // Ϊ�ο�
				for(CartItem item : con){
					// Ϊ���ʼ�����
					Product p = item.getProduct();
					String name = p.getProductname();
					String catalog = p.getCategoryno();
					String cas = p.getCas();
					String formula = p.getCategory();
					float mw = p.getPrice1();
					int quantity = item.getQuantity();
					String temp = "<tr  bgcolor='#99CCFF'> <td width='71' class='table_hei'>"
							+ catalog
							+ "</td><td width='100' class='table_hei'>"
							+ name
							+ "</td><td width='107' class='table_hei'>"
							+ cas
							+ "</td><td width='64' class='table_hei'>"
							+ formula
							+ "</td><td  width='82' class='table_hui'>"
							+ mw
							+ " ��</td><td width='59' height='26'  class='table_hui'>"
							+ quantity + "</td></tr>";
					content += temp;
				}
			} else {// Ϊע���û�
				//�����û���Ϣ
				String sqlusr = "update usr set username=?,email=?,companyname=?,companyaddress=?,tel=? where id=?";
				
				pst = conn.prepareStatement(sqlusr);
				pst.setString(1, pu.getUsername());
				pst.setString(2, pu.getEmail());
				pst.setString(3, pu.getCompanyname());
				pst.setString(4, pu.getCompanyaddress());
				pst.setString(5, pu.getTel());
				pst.setInt(6, pu.getId());
				pst.executeUpdate();
				
				// �ѵ�ǰʱ��Ϊ���涩����ʱ��
				Date currentTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
				String ordernumber = pu.getUsername()+"-"+formatter.format(currentTime);
		
				// ���涩��

				String sql = "insert into orders (usrid,ordernumber,createtime,delsoft) values (?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, pu.getId());
				pst.setString(2, ordernumber);
				pst.setDate(3, new java.sql.Date(currentTime.getTime()));
				pst.setString(4, "0");
				pst.executeUpdate();
				String sqls = "select * from orders o where o.usrid=? and o.ordernumber=?";
				pst = conn.prepareStatement(sqls);
				pst.setInt(1, pu.getId());
				pst.setString(2,ordernumber);
				rs = pst.executeQuery();
				int orderid = 0;
				if (rs.next()) {
					orderid = rs.getInt("id");// ��ȡ�±���Ķ���
				}
				
				// ��ӹ��ﳵ��Ʒ����
				if (orderid != 0){  // �����Ŵ���
				
					for(CartItem item : con){
						// Ϊ���ʼ�����
						Product p = item.getProduct();
						String sqlor = "insert into orderitem (ordersid,productid,quantity) values (?,?,?)";
						pst = conn.prepareStatement(sqlor);
						pst.setInt(1, orderid);
						pst.setInt(2, p.getId());
						pst.setString(3, item.getQuantity()+"");
						
						pst.executeUpdate();

						// ���汣�涩�� ����Ϊ���ʼ�����
						String name = p.getProductname();
						String catalog = p.getCategoryno();
						String cas = p.getProductname();
						String formula = p.getCategory();
						float mw = p.getPrice1();
						int quantity = item.getQuantity();
						String temp = "<tr  bgcolor='#99CCFF'> <td width='71' class='table_hei'>"
								+ catalog
								+ "</td><td width='100' class='table_hei'>"
								+ cas
								+ "</td><td width='107' class='table_hei'>"
								+ name
								+ "</td><td width='64' class='table_hei'>"
								+ formula
								+ "</td><td  width='82' class='table_hui'>"
								+ mw
								+ " ��</td><td width='59' height='26'  class='table_hui'>"
								+ quantity + "</td></tr>";
						content += temp;
					}
				} else {
					System.out.println("��������ʧ��");
				}
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * ����ע���û��Ķ���
	 * @param uid �û�id
	 * @return ���û����ж�������
	 * @throws SQLException
	 */
	public List<Orders> findOrderList(int uid) throws SQLException {
		List<Orders> list = new ArrayList<Orders>();
		Connection con = DataAccess.getConnection();

		String sql = "select * from orders o where o.usrid=? and o.delsoft=0 order by o.id desc";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, uid);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Orders od = new Orders();
			od.setId(rs.getInt("id"));
			od.setOrdernumber(rs.getString("ordernumber"));
			od.setUsrid(rs.getInt("usrid"));
			od.setCreatetime(rs.getDate("createtime"));
			od.setDelsoft(rs.getString("delsoft"));
			list.add(od);
		}
		rs.close();
		pst.close();
		con.close();
		return list;
	}

	/**
	 * ���ҷ���ɾ�����ж���
	 * @return ����ɾ����������
	 * @throws SQLException
	 */
	public List<Orders> findOrderAllList() throws SQLException {
		List<Orders> list = new ArrayList<Orders>();
		Connection con = DataAccess.getConnection();
		String sql = "select * from orders o where o.delsoft='0' order by o.id desc";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Orders od = new Orders();
			od.setId(rs.getInt("id"));
			od.setOrdernumber(rs.getString("ordernumber"));
			od.setUsrid(rs.getInt("usrid"));
			od.setCreatetime(rs.getDate("createtime"));
			od.setDelsoft(rs.getString("delsoft"));
			list.add(od);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	/**
	 * ���ݶ�����ѯ���иö�����Ʒ
	 * @param orderid ����id
	 * @return �ö�����Ʒ����
	 * @throws SQLException
	 */
	public List<Product> findOrderItem(int orderid) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		Connection con = DataAccess.getConnection();
		String sql = "select * from product where id in(select productid from orderitem o where o.ordersid=?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, orderid);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Product pu = new Product();
			pu.setId(rs.getInt("id"));
			pu.setProductnumber(rs.getString("productnumber"));
			pu.setProductname(rs.getString("productname"));
			pu.setCategoryno(rs.getString("categoryno"));
			pu.setCategory(rs.getString("category"));
			pu.setImagepath(rs.getString("imagepath"));
			pu.setIsnewproduct(rs.getString("isnewproduct"));
			pu.setPrice1(rs.getFloat("price1"));
			pu.setPrice2(rs.getFloat("price2"));
			pu.setRealstock(rs.getString("realstock"));
			pu.setStock(rs.getString("stock"));
			pu.setCas(rs.getString("cas"));
			pu.setMdlint(rs.getString("mdlint"));
			pu.setFormula(rs.getString("formula"));
			pu.setWeight(rs.getString("weight"));
			pu.setDelsoft(rs.getString("delsoft"));
			pu.setNote(rs.getString("note"));
			list.add(pu);
		}
		rs.close();
		pst.close();
		con.close();
		return list;
	}

	/**
	 * ɾ�����������Ʒ��Ϣ
	 * @param pid ��Ʒid
	 * @param orderid ����id
	 * @throws SQLException
	 */
	public void delOrderItem(int pid, int orderid) throws SQLException {
		Connection con = DataAccess.getConnection();
		String sql = "delete from orderitem  where ordersid=? and productid =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, orderid);
		pst.setInt(2, pid);
		pst.executeUpdate();
		pst.close();
		con.close();
	}

	/**
	 * ɾ������(����ɾ��)
	 * @param orderid ����id
	 * @throws SQLException
	 */
	public void delOrder(int orderid) throws SQLException {
		Connection con = DataAccess.getConnection();
		PreparedStatement pst = null ;
		String sqls = "delete from orderitem  where id=?";
		String sql = "delete from orders  where id=?";
		try {
			con.setAutoCommit(false);
			
			pst = con.prepareStatement(sqls);
			pst.setInt(1, orderid);
			pst.executeUpdate();
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, orderid);
			pst.executeUpdate();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally{
			try {
				if(pst!=null){
					pst.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * ɾ������(��ɾ��)
	 * @param orderid ����id
	 * @throws SQLException
	 */
	public void delOrdersoft(int orderid) throws SQLException {
		Connection con = DataAccess.getConnection();
		String sql = "update orders set delsoft='1' where orderid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, orderid);
		pst.executeUpdate(sql);
		pst.close();
		con.close();
	}
}
