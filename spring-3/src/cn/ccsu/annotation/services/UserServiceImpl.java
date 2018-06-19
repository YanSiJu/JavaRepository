package cn.ccsu.annotation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccsu.annotation.Repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public void add() {
		// TODO Auto-generated method stub

		System.out.println("UserServiceImpl....");
		this.repository.respository();

	}

}
