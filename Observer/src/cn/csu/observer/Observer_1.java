package cn.csu.observer;

import cn.csu.subject.Subject;

public class Observer_1 extends Observer {

	public Observer_1() {

	}

	@Override
	public void singRep(Subject s) {
		System.out.println("boy 1 看到女孩在唱歌");

	}

	@Override
	public void danceRep(Subject s) {
		System.out.println("boy 1 看到女孩在跳舞");
		s.detach();

	}

}
