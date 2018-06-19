package cn.ccsu.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.SalesRecord;

/**
 * @author Bill
 *
 */
@Repository
public interface SalesRecordMapper {
	// 增加销售记录
	/**
	 * @param record
	 */
	/**
	 * @param record
	 */
	void addSalesRecord(SalesRecord record);

	// 查询销售记录
	/**
	 * @param params
	 * @return
	 */
	List<SalesRecord> selectSalesRecord(Map<String, Object> params);

	// 查询所有销售记录
	/**
	 * @return
	 */
	List<SalesRecord> selectAllSalesRecords();

	// 更新销售记录
	/**
	 * @param record
	 */
	void updateSalesRecord(SalesRecord record);

	// 删除销售记录
	/**
	 * @param recordId
	 */
	void deleteSalesRecord(Integer recordId);

	// 根据id查询销售记录
	/**
	 * @param recordId
	 * @return
	 */
	SalesRecord selectSalesRecordById(Integer recordId);
}
