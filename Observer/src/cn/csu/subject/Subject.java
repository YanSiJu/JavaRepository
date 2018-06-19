package cn.csu.subject;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cn.csu.observer.Observer;

public abstract class Subject {

	protected List<Observer> myObs;
	protected ListIterator<Observer> itr;

	public Subject() {
		myObs = new LinkedList<>();
		itr = myObs.listIterator();
	}

	public abstract void dance();

	public abstract void sing();

	public void attach(Observer obs) {
		myObs.add(obs);
	}

	public void detach() {
		itr.remove();
	}

}
