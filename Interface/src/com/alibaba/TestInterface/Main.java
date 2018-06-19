package com.alibaba.TestInterface;

public class Main implements Person {

	public static void main(String[] args) {

		Worker w = new Worker();
		w.walk();
		System.out.println(IStudy.I);
	}

	@Override
	public void Swim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void StudyEnglish() {
		// TODO Auto-generated method stub

	}
}
