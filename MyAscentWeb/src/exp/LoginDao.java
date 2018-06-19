package exp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ascent.util.DataAccessJDBC;
import com.ascent.bean.Usr;

public class LoginDao {

	public Usr Login(String username) {
		Usr user = null;

		String sql = "select * from usr where username='" + username+"'";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = DataAccessJDBC.getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user = new Usr();
				user.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
