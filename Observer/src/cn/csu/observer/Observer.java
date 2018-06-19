package cn.csu.observer;

import cn.csu.subject.Subject;

public abstract class Observer {

	public Observer() {

	}

	public abstract void singRep(Subject s);

	public abstract void danceRep(Subject s);

}
