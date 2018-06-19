package cn.ccsu.service;

import java.util.List;
import cn.ccsu.entity.MonthlyRecord;

/**
 * @author Bill
 *
 */
public interface IMonthlyRecordService {

	// 增加月销售记录
	int addMonthlyRecord(MonthlyRecord record);

	// 查询月销售记录
	List<MonthlyRecord> queryMonthlyRecord(Integer productId, Integer salesmanId,String month);

	/*// 查询月销售记录
	List<MonthlyRecord> queryMonthlyRecord(Integer productId, Integer salesmanId);*/

	// 更新月销售记录
	int modifyMonthlyRecord(MonthlyRecord record);

	// 删除月销售记录
	int deleteMonthlyRecord(MonthlyRecord record);
}
