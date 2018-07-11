package cn.csu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import cn.csu.dao.util.DaoUtil;
import cn.csu.entity.Stockin;
import cn.csu.entity.Stockout;

public class StockoutDao extends DaoUtil {

	public void stockout(int userId, LocalDate date, int proId, int count) {
		String sql = "INSERT INTO tb_stockout(userId,wareId,date) VALUES (?,?,?)";
		Connection conn = getConnection();
		if (conn != null) {
			int wareId = queryWareId(proId);
			if (wareId != -1) {
				this.update(conn, sql, userId, wareId, date);
			}
		}
		int stockoutId = queryStockoutId();
		if (stockoutId != -1) {
			insertProduct(stockoutId, proId, count);
		}

	}

	private int queryStockoutId() {
		String sql = "select MAX(tb_stockout.stockoutId) from  tb_stockout";
		Connection conn = getConnection();
		Stockout stockout = null;
		if (conn != null) {
			stockout = this.getRecord(Stockout.class, conn, sql);
			if (stockout != null) {
				return stockout.getStockoutId();
			}
		}
		return -1;
	}

	private int queryWareId(int proId) {
		String sql = "select  * from tb_stockin WHERE tb_stockin.stockinId = ( select tb_stockindet.stockinId from tb_stockindet WHERE tb_stockindet.proId = ?)";
		Connection conn = getConnection();
		Stockin stockin = null;
		if (conn != null) {
			stockin = this.getRecord(Stockin.class, conn, sql, proId);
			if (stockin != null) {
				return stockin.getWareId();
			}
		}
		return -1;
	}

	private void insertProduct(int stockoutId, int proId, int count) {
		Connection conn = getConnection();
		String sql = "INSERT INTO  tb_stockoutdet(stockoutId,proId,count) VALUES (?, ?,?)";
		if (conn != null) {
			this.update(conn, sql, stockoutId, proId, count);
		}
	}

	private Connection getConnection() {
		try {
			return this.connectDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
