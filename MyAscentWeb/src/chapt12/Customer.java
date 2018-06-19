package chapt12;
import java.sql.*;
import java.util.*;

import com.ascent.util.DataAccessJDBC;
public class Customer {
        //javabean 's property
        private int custId ;  // only to get uid
        private String user;
        private String password;
        private String name;
        private String title;  // values F: for female ; M: for male.
        private String email;
        private boolean checkin = false;
        //method
//        public Customer() {
//        }
        //getXXX/setXXX(){}
//        public int getCustid(){ return custId;}
//        public String getUser() { return user;}
//        public String getPassword(){return password;}
//        public String getName() {return name;}
//        public String getTitle(){return title;}
//        public String getEmail() {return email;}
//        public boolean getCheckin() {return this.checkin;}
//
//        public void setCustid(int cid){this.custId = cid;}
//        public void setUser(String user){this.user = user;}
//        public void setPassword(String password){this.password = password;}
//        public void setName(String name){this.name = name;}
//        public void setTitle(String title){this.title = title;}
//        public void setEmail(String email){this.email = email;}
//        public void setCheckin(boolean checkin){this.checkin = checkin;}

        
        public void newCustomer(){}
        public int getCustId() {
			return custId;
		}


		public void setCustId(int custId) {
			this.custId = custId;
		}


		public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public boolean isCheckin() {
			return checkin;
		}


		public void setCheckin(boolean checkin) {
			this.checkin = checkin;
		}
/************
 * 
 * @param user 用户名
 * @param password
 * @return 是否登录成功
 * @throws SQLException
 */

		public boolean login(String user, String password) throws SQLException {
          boolean succ = false;
          Connection con = DataAccessJDBC.getConnection();
          String sql = "select * from usr where username='"
                       + user+"' AND password ='"
                       + password+"'";
          Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()){
            succ = true;;
          }
          rs.close();
          stmt.close();
          con.close();
          return succ;

        }

        public void saveInfo() throws Exception {
		    Connection con = DataAccessJDBC.getConnection();
		    String sqlStr = "insert into usr(username,password) "
		                    + "  values('" +this.getUser()+"',"
		                                  + "'"+this.getPassword()+"')";
		    Statement stmt = con.createStatement();
		    stmt.executeUpdate(sqlStr);
		    stmt.close();
		    con.close();
  }
        public boolean logOut(){ return false;}     
}
