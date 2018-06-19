package cn.ccsu.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StockMapper {

	boolean updateStock(Integer id);

	Integer queryStock(Integer id);

}
