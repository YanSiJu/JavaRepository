package cn.ccsu.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {

	Integer queryPrice(Integer id);
}
