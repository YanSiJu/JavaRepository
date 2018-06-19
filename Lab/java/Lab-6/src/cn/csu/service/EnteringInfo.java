package cn.csu.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import cn.csu.bean.Student;

public class EnteringInfo {

	
	public static void test() throws Exception {

		String sno;
		String name;
		String classNo;
		String grade;

		Scanner in = new Scanner(System.in);

		System.out.println("请输入学号 姓名 班级 成绩 ");
		sno = in.nextLine();
		if(sno == null || sno.equals("")) {
			throw new Exception("学号输入有误，请重新输入！！");
		}

		name = in.nextLine();
		if(name == null || name.equals("")) {
			throw new Exception("姓名输入有误，请重新输入！！");
		}
		
		classNo = in.nextLine();
		if(classNo == null || !EnteringInfo.isNumeric(classNo) || Integer.parseInt(classNo)< 0) {
			throw new Exception("班级号输入有误，请重新输入！！");
		}
		
		grade = in.next();
		if(grade == null || !EnteringInfo.isNumeric(grade) || Double.parseDouble(grade)< 0) {
			throw new Exception("成绩输入有误，请重新输入！！");
		}
		
		Student s = new Student(sno,name,classNo,Double.parseDouble(grade));
		System.out.println("student:"+s);

	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");

		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		} else {
			return true;
		}

	}
}
