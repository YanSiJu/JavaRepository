package com.ascent.dao;

import java.sql.*;
import java.util.*;

import com.ascent.util.DataAccess;
import com.ascent.bean.Product;

/**
 * 对商品信息进行相关操作的类
 * @author zy
 */
public class ProductDAO {

	/**
	 * 查询所有商品对象
	 * @return
	 */
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		Connection con = DataAccess.getConnection();
		String sql = "select * from product p where delsoft='0'  order by p.id ";
		Statement stmt = null ;
		ResultSet rs = null ;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;

	}

	/**
	 * 根据pid主键查询商品对象
	 * @param pid 商品id
	 * @return 商品对象
	 */
	public Product getProductByPid(int pid) {
		Connection con = DataAccess.getConnection();
		String sql = "select * from product p where p.id=? order by p.id ";
		Product pu = null;
		PreparedStatement pst = null;
		ResultSet rs = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if (rs.next()) {
				pu = new Product();
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
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
		return pu;

	}

	/**
	 * 根据pid主键删除商品
	 * @param pid 商品id
	 */
	public void delProductByPid(int pid) {
		Connection con = DataAccess.getConnection();
		String sql = "delete from product where id=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
		} catch (SQLException e) {
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
	 * 保存产品信息
	 * @param pdt 商品对象
	 * @throws SQLException
	 */
	public void saveProduct(Product pdt) throws SQLException {
		Connection con = DataAccess.getConnection();
		String sql = "insert into product (productnumber,productname,categoryno,category,imagepath,isnewproduct,price1,price2,realstock,stock,cas,mdlint,formula,weight,delsoft,note) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, pdt.getProductnumber());
			pst.setString(2, pdt.getProductname());
			pst.setString(3, pdt.getCategoryno());
			pst.setString(4, pdt.getCategory());
			pst.setString(5, pdt.getImagepath());
			pst.setString(6, pdt.getIsnewproduct());
			pst.setFloat(7, pdt.getPrice1());
			pst.setFloat(8, pdt.getPrice2() );
			pst.setString(9, pdt.getRealstock());
			pst.setString(10, pdt.getStock());
			pst.setString(11, pdt.getCas());
			pst.setString(12, pdt.getMdlint());
			pst.setString(13, pdt.getFormula());
			pst.setString(14, pdt.getWeight());
			pst.setString(15, pdt.getNote());
			pst.executeUpdate();
		} catch (SQLException e) {
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
	 * 修改产品信息
	 * @param pdt 商品对象
	 * @throws SQLException
	 */
	public void updateProduct(Product pdt) throws SQLException {
		Connection con = DataAccess.getConnection();
		StringBuffer sql = new StringBuffer("update product  set  productnumber=?,productname=?,categoryno=?,category=?,isnewproduct=?,price1=?,price2=?,realstock=?,stock=?,cas=?,mdlint=?,formula=?,weight=?,note=? ");
		if (pdt.getImagepath() != null && !pdt.getImagepath().equals("")) {
			sql.append(",imagepath='"+pdt.getImagepath()+"' ");
		}
		sql.append(" where id=?");
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, pdt.getProductnumber());
			pst.setString(2, pdt.getProductname());
			pst.setString(3, pdt.getCategoryno());
			pst.setString(4, pdt.getCategory());
			pst.setString(5, pdt.getIsnewproduct());
			pst.setFloat(6, pdt.getPrice1());
			pst.setFloat(7, pdt.getPrice2() );
			pst.setString(8, pdt.getRealstock());
			pst.setString(9, pdt.getStock());
			pst.setString(10, pdt.getCas());
			pst.setString(11, pdt.getMdlint());
			pst.setString(12, pdt.getFormula());
			pst.setString(13, pdt.getWeight());
			pst.setString(14, pdt.getNote());
			pst.setInt(15, pdt.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
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
	 * 根据类型和关键字查询商品
	 * @param searchName 商品字段名称
	 * @param searchValue 商品字段对应的关键字值
	 * @return 查询的商品
	 */
	public List<Product> searchProcuct(String searchName, String searchValue) {
		Connection con = DataAccess.getConnection();
		String sql = "select * from product p where p." + searchName + " like '%" + searchValue.trim() + "%' and p.delsoft='0' ";
		Statement stmt = null;
		ResultSet rs =  null ;
		List<Product> productlist = new ArrayList<Product>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
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
				productlist.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return productlist;
	}
}
