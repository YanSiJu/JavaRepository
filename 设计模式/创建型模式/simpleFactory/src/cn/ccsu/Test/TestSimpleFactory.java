package cn.ccsu.Test;

import java.util.Scanner;

import cn.ccsu.simpleFactory.Operation;
import cn.ccsu.simpleFactory.OperationFactory;

public class TestSimpleFactory {
	
	public static void main(String[] args){
		
		try {
			System.out.println("请输入2个操作数:");
			Operation oper = OperationFactory.factoryMethod("div");
			Scanner in = new Scanner(System.in);
			oper.setNumber1(in.nextDouble());
			oper.setNumber2(in.nextDouble());
			System.out.println(oper.getResult());
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
