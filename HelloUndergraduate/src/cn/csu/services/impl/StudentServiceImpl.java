package cn.csu.services.impl;

import java.util.Random;

import cn.csu.beans.Student;
import cn.csu.services.IStudentService;

public class StudentServiceImpl implements IStudentService {

	private static final int MAX = 100000;
	private static final int MIN = 1;
	private static final String SUCCESS = "success";
	@SuppressWarnings("unused")
	private static final String FAIL = "fail";

	@Override
	public String register(Student s) {
		// TODO Auto-generated method stub

		// 在数据库中查找该学生的用户名，若用户名已存在，则注册失败

		Random r = new Random();

		Integer id = r.nextInt(MAX) % (MAX - MIN + 1) + MIN;

		// 在数据库中查找该id,确保id不重复。若重复，则循环重新生成。直至id唯一

		@SuppressWarnings("unused")
		String stuId = String.valueOf(id);

		// 将学生信息插入数据库

		
		return SUCCESS;
	}

	@Override
	public String login(String userName,String password) {
		// TODO Auto-generated method stub
		
		//在数据库中查找相应信息，并返回状态
		return null;
		
	}

	@Override
	public String modifyPassword(String userName,String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		
		//若账号和密码正确,则可以修改密码
		
		
		
		return null;
	}

}
