package cn.csu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import cn.csu.dao.util.DaoUtil;
import cn.csu.entity.Stockin;

public class StockinDao extends DaoUtil {

	public void stockin(int userId, int wareId, LocalDate date, String remark, int proId, int count) {
		String sql = "INSERT INTO tb_stockin(wareId,userId,date,remark) VALUES (?, ?,?, ?)";
		Connection conn = getConnection();
		if (conn != null) {
			this.update(conn, sql, wareId, userId, date, remark);
		}
		int stockinId = queryStockinId();
		if (stockinId != -1) {
			insertProduct(stockinId, proId, count);
		}

	}

	private void insertProduct(int stockinId, int proId, int count) {
		Connection conn = getConnection();
		String sql = "INSERT INTO  tb_stockindet(stockinId,proId,count) VALUES (?, ?,?)";
		if (conn != null) {
			this.update(conn, sql, stockinId, proId, count);
		}
	}

	@SuppressWarnings("unused")
	private void insertProducts(int stockinId, Map<Integer, Integer> products) {
		Connection conn = getConnection();
		String sql = "INSERT INTO  tb_stockindet(stockinId,proId,count) VALUES (?, ?,?)";
		if (conn != null) {
			for (Entry<Integer, Integer> entry : products.entrySet()) {
				// entry.getKey():proId
				// entry.getValue():count
				this.update(conn, sql, stockinId, entry.getKey(), entry.getValue());
			}
		}

	}

	private int queryStockinId() {
		String sql = "select MAX(tb_stockin.stockinId)  from  tb_stockin";
		Connection conn = getConnection();
		Stockin stockin = null;
		if (conn != null) {
			stockin = this.getRecord(Stockin.class, conn, sql);
			if (stockin != null) {
				return stockin.getStockinId();
			}
		}
		return -1;
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
