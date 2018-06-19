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

		// 1. ��ȡ��ĵ���
		Integer price = bookMapper.queryPrice(id);

		// 2. ������Ŀ��
		if (stockMapper.queryStock(id) == 0) {
			throw new BookStockException("��治��!");
		}
		System.out.println("������Ŀ��:" + stockMapper.updateStock(id));

		// 3. �����û����
		if (userMapper.queryBalance(userName) < price) {
			throw new UserAccountException("����!");
		}
		System.out.println("\n�����û����:" + userMapper.updateBalance(userName, price));

	}

}
