package cn.ccsu.service;

import java.util.List;
import cn.ccsu.entity.ProductMonthlyRecord;
import cn.ccsu.entity.SalesmanMonthlyRecord;

/**
 * @author Bill
 *
 */
public interface ISummarizeMonthlySaleInfoService {

	// 统计销售员的月销售额
	List<SalesmanMonthlyRecord> querySalmanMonthlySaleRoom();

	// 统计产品的月销售额
	List<ProductMonthlyRecord> queryProductMonthlySaleRoom();

}
