package cn.csu.services;

import cn.csu.beans.Student;

public interface IStudentService {

	public String register(Student s);

	public String login(String userName,String password);

	public String modifyPassword(String userName,String oldPassword,String newPassword);
}
