package cn.csu.entity;

import java.util.LinkedList;
import java.util.List;

public class Menu {

	private List<MenuItem> menuItems;

	public Menu(){
		menuItems = new LinkedList<MenuItem>();
	}
	
	public void addMenuItem(MenuItem item) {
		menuItems.add(item);
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	
}
