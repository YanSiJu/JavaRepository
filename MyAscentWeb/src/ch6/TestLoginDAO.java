package ch6;

import com.ascent.bean.Usr;
import com.ascent.dao.LoginDAO;

public class TestLoginDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDAO dao = new LoginDAO();
//		Usr u = dao.logIn("ascent", "ascent");
		Usr u = dao.logIn("admin", "123");
		if(u!=null){
			System.out.println("��¼�ɹ�");
			String superuser = u.getSuperuser();
			if(superuser != null && "3".equals(superuser)){
				System.out.println("���ǹ���Ա");
			}
			else {
				System.out.println("������ͨ�û�");
			}
		}
		else{
			System.out.println("��¼ʧ��");
		}

	}

}
