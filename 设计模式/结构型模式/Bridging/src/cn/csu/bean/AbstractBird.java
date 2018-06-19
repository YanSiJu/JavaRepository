package cn.csu.bean;

import cn.csu.service.IBehavior;

public abstract class AbstractBird {

	IBehavior behavior;
	
	public abstract void display();

	public void setBehavior(IBehavior behavior) {
		this.behavior = behavior;
	}

	public IBehavior getBehavior() {
		return behavior;
	} 

}
