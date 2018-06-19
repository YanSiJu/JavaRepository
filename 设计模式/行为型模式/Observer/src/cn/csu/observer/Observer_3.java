package cn.csu.observer;

import cn.csu.subject.Subject;

public class Observer_3 extends Observer {

	public Observer_3() {

	}

	@Override
	public void singRep(Subject s) {
		System.out.println("boy 3 看到女孩在唱歌");

	}

	@Override
	public void danceRep(Subject s) {
		System.out.println("boy 3 看到女孩在跳舞");

	}

}
