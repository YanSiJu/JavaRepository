package cn.ccsu.repository;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	public Dao() {

		System.out.println("Dao  constructor");
	}

	public void select() {

		System.out.println("Dao select!!");
	}

}
