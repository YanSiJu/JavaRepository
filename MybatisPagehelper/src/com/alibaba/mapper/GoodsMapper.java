package com.alibaba.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.Goods;

@Repository
public interface GoodsMapper {

	
	List<Goods> queryGoods();
}
