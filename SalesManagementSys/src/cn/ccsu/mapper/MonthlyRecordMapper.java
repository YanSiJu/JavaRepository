package cn.ccsu.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.MonthlyRecord;

/**
 * @author Bill
 *
 */
@Repository
public interface MonthlyRecordMapper {

	// 增加月销售记录
	void addMonthlyRecord(MonthlyRecord record);

	// 查询月销售记录
	List<MonthlyRecord> selectMonthlyRecord(Map<String, Object> params);

	// 更新月销售记录
	void updateMonthlyRecord(MonthlyRecord record);

	// 删除月销售记录
	void deleteMonthlyRecord(Map<String, Object> params);
}
