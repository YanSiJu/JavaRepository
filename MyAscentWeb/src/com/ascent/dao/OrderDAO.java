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
 * 对订单对象，及订单项进行操作的类
 * @author zy
 */
public class OrderDAO {

	/**
	 * 保存订单对象
	 * @param con 订单项集合
	 * @param pu 订单所属用户
	 * @return 邮件内容
	 * @throws SQLException
	 */
	public String saveOrder(Collection<CartItem> con, Usr pu) throws SQLException {

		Connection conn = DataAccess.getConnection();
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		String content = "";// 邮件内容
		
		try {
			conn.setAutoCommit(false);
			int uid = pu.getId();
			if (uid == 0){ // 为游客
				for(CartItem item : con){
					// 为发邮件内容
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
							+ " ￥</td><td width='59' height='26'  class='table_hui'>"
							+ quantity + "</td></tr>";
					content += temp;
				}
			} else {// 为注册用户
				//更新用户信息
				String sqlusr = "update usr set username=?,email=?,companyname=?,companyaddress=?,tel=? where id=?";
				
				pst = conn.prepareStatement(sqlusr);
				pst.setString(1, pu.getUsername());
				pst.setString(2, pu.getEmail());
				pst.setString(3, pu.getCompanyname());
				pst.setString(4, pu.getCompanyaddress());
				pst.setString(5, pu.getTel());
				pst.setInt(6, pu.getId());
				pst.executeUpdate();
				
				// 已当前时间为保存订单的时间
				Date currentTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
				String ordernumber = pu.getUsername()+"-"+formatter.format(currentTime);
		
				// 保存订单

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
					orderid = rs.getInt("id");// 获取新保存的订单
				}
				
				// 添加购物车商品集合
				if (orderid != 0){  // 订单号存在
				
					for(CartItem item : con){
						// 为发邮件内容
						Product p = item.getProduct();
						String sqlor = "insert into orderitem (ordersid,productid,quantity) values (?,?,?)";
						pst = conn.prepareStatement(sqlor);
						pst.setInt(1, orderid);
						pst.setInt(2, p.getId());
						pst.setString(3, item.getQuantity()+"");
						
						pst.executeUpdate();

						// 上面保存订单 下面为发邮件内容
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
								+ " ￥</td><td width='59' height='26'  class='table_hui'>"
								+ quantity + "</td></tr>";
						content += temp;
					}
				} else {
					System.out.println("订单保存失败");
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
	 * 查找注册用户的订单
	 * @param uid 用户id
	 * @return 该用户所有订单对象
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
	 * 查找非软删除所有订单
	 * @return 非软删除订单对象
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
	 * 根据订单查询所有该订单商品
	 * @param orderid 订单id
	 * @return 该订单商品对象
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
	 * 删除订单里的商品信息
	 * @param pid 产品id
	 * @param orderid 订单id
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
	 * 删除订单(永久删除)
	 * @param orderid 订单id
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
	 * 删除订单(软删除)
	 * @param orderid 订单id
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
