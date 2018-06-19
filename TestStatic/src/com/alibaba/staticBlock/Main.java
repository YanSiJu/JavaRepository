package com.alibaba.staticBlock;

public class Main {

	public Main() {

		this.NATION = "";
	}

	public Main(String name, String nation, int id) {
		super();
		this.name = name;
		this.NATION = nation;
		this.id = id;
	}

	private String name;
	@SuppressWarnings("unused")
	private final String NATION;

	@Override
	public String toString() {
		return "Main [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// ÊµÀý¿é1
	{

		this.id = 1008;
	}

	private int id = 2017;

	// ÊµÀý¿é2
	{

		this.id = 1009;
	}

}
