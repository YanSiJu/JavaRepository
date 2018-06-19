package cn.csu.subject;

import cn.csu.observer.Observer;

public class Girl extends Subject {

	public Girl() {

	}

	public void dance() {

		itr = myObs.listIterator();
		while (itr.hasNext()) {
			Observer o = itr.next();
			o.danceRep(this);
		}
	}

	public void sing() {
		for (Observer o : myObs) {
			o.singRep(this);
		}
	}

}
