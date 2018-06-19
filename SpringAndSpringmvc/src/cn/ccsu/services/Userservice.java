package cn.ccsu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccsu.repository.Dao;

@Service
public class Userservice {

	public Userservice() {

		System.out.println("UserService constructor");
	}

	@Autowired
	private Dao dao;

	public boolean add() {

		System.out.println("Userservice  add");
		this.dao.select();
		return false;
	}
}
