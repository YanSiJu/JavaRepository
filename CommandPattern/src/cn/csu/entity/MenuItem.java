package cn.csu.entity;

import cn.csu.entity.command.AbstractCommand;

public class MenuItem {

	private AbstractCommand command;

	public MenuItem() {

	}

	public MenuItem(AbstractCommand command) {
		this.command = command;
	}

	public void click() {
		command.execute();
	}
}
