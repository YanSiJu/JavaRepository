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

		// �����ݿ��в��Ҹ�ѧ�����û��������û����Ѵ��ڣ���ע��ʧ��

		Random r = new Random();

		Integer id = r.nextInt(MAX) % (MAX - MIN + 1) + MIN;

		// �����ݿ��в��Ҹ�id,ȷ��id���ظ������ظ�����ѭ���������ɡ�ֱ��idΨһ

		@SuppressWarnings("unused")
		String stuId = String.valueOf(id);

		// ��ѧ����Ϣ�������ݿ�

		
		return SUCCESS;
	}

	@Override
	public String login(String userName,String password) {
		// TODO Auto-generated method stub
		
		//�����ݿ��в�����Ӧ��Ϣ��������״̬
		return null;
		
	}

	@Override
	public String modifyPassword(String userName,String oldPassword,String newPassword) {
		// TODO Auto-generated method stub
		
		//���˺ź�������ȷ,������޸�����
		
		
		
		return null;
	}

}
