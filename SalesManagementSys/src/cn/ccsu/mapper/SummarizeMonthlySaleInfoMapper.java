package cn.ccsu.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.ProductMonthlyRecord;
import cn.ccsu.entity.SalesmanMonthlyRecord;

/**
 * @author Bill
 *
 */
@Repository
public interface SummarizeMonthlySaleInfoMapper {

	// 统计销售员的月销售额
	List<SalesmanMonthlyRecord> querySalmanMonthlySaleRoom();

	// 统计产品的月销售额
	List<ProductMonthlyRecord> queryProductMonthlySaleRoom();
}
