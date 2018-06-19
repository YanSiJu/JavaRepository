package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ascent.bean.Usr;
import com.ascent.util.DataAccessJDBC;
 

public class UserManagerDao {
	
	Connection conn = null;
	ResultSet rs = null;

	
	public ArrayList<Usr> getAllUser(){
		conn = DataAccessJDBC.getConnection();

		ArrayList<Usr> users = new ArrayList<Usr>();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from usr  ";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			Usr user = new Usr();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			users.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
		
		
	}
	
	public boolean register(Usr u){
		//flag 为false表示插入不成功
		boolean flag = false;
		
		conn = DataAccessJDBC.getConnection();
		String sql = "select * from usr where username='" +  u.getUsername() +"'";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(!rs.next()){//此人不存在
				sql = "insert into usr(username,password)  values('"+u.getUsername() +"','"+u.getPassword()+"')";
				int i = stmt.executeUpdate(sql);
				if(i!=0)
					flag = true;
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
