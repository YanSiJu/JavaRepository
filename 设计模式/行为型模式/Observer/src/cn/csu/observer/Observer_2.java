package cn.csu.observer;

import cn.csu.subject.Subject;

public class Observer_2 extends Observer {

	public Observer_2() {

	}

	@Override
	public void singRep(Subject s) {
		System.out.println("boy 2 ����Ů���ڳ���");

	}

	@Override
	public void danceRep(Subject s) {
		System.out.println("boy 2 ����Ů��������");

	}

}
