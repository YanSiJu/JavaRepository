package cn.ccsu.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.ccsu.service.IUserService;

@Repository("iUserServiceImpl")
public class IUserServiceImpl implements IUserService {

	public IUserServiceImpl() {

	}

	@Transactional
	@Override
	public void addUser() {

	}

}
