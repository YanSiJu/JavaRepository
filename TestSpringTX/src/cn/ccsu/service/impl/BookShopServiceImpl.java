package cn.ccsu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.ccsu.dao.BookMapper;
import cn.ccsu.dao.StockMapper;
import cn.ccsu.dao.UserMapper;
import cn.ccsu.exception.BookStockException;
import cn.ccsu.exception.UserAccountException;
import cn.ccsu.service.BookShopService;

@Service("bookShopServiceImpl")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private StockMapper stockMapper;

	public BookShopServiceImpl() {

	}

	@Transactional(rollbackFor=UserAccountException.class)
	@Override
	public void purchase(String userName, Integer id) throws Exception {

		// 1. 获取书的单价
		Integer price = bookMapper.queryPrice(id);

		// 2. 更新书的库存
		if (stockMapper.queryStock(id) == 0) {
			throw new BookStockException("库存不足!");
		}
		System.out.println("更新书的库存:" + stockMapper.updateStock(id));

		// 3. 更新用户余额
		if (userMapper.queryBalance(userName) < price) {
			throw new UserAccountException("余额不足!");
		}
		System.out.println("\n更新用户余额:" + userMapper.updateBalance(userName, price));

	}

}
