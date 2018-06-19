package cn.csu.test;

import cn.csu.beans.GeneralUser;
import cn.csu.beans.User;
import cn.csu.beans.VIPUser;

public class UserTest {

	public static void main(String args[]) {
		//public User(String name, String pwd, int born, String type)
		
		User gerneralUser = new GeneralUser("马可", "259614", 1970,"GeneralUser");
		User vipUser = new VIPUser("汪涵", "123456", 1974,"VIPUser");
		gerneralUser.information();
		vipUser.information();
	}

}
