package cn.csu.observer;

import cn.csu.subject.Subject;

public class Observer_1 extends Observer {

	public Observer_1() {

	}

	@Override
	public void singRep(Subject s) {
		System.out.println("boy 1 ����Ů���ڳ���");

	}

	@Override
	public void danceRep(Subject s) {
		System.out.println("boy 1 ����Ů��������");
		s.detach();

	}

}
