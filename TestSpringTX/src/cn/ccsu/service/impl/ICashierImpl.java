package cn.ccsu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.ccsu.service.BookShopService;
import cn.ccsu.service.ICashier;

@Service("iCashierImpl")
public class ICashierImpl implements ICashier {

	@Autowired
	private BookShopService bookShopService;

	public ICashierImpl() {

	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void checkout(String username, List<Integer> ids) throws Exception {
		for (Integer id : ids) {
			bookShopService.purchase(username, id);
		}
	}

}
