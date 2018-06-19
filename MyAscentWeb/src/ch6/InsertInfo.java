package ch6;
import java.sql.*;
/**
 * <p>Title: databaseMySQL</p>
 * <p>Description: </p>
 * <p>Company: ascent</p>
 * @version 1.0
 */
public class InsertInfo {
  public static void main(String[] args) {
    try {
           //step 1 Registering a driver
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/*           Class.forName("com.mysql.jdbc.Driver");
  
           //step 2 Establishing a connection to the database
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ascentweb","root","123456");
*/           Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;DatabaseName=MBOOK","sa","admin");
           
			//step 3 Creating a statement ,  此表以name为主键
           PreparedStatement pstm = con.prepareStatement("insert into liutable(sex,name, age) values( ?,?,?)");
           
           //step 4 and 5 Executing a SQL, Processing the results
           for(int i = 0; i < 10; i++) {
               pstm.setString(1,  "female");
               pstm.setString(2, "name"+i);
               pstm.setInt(3,  i);
               pstm.executeUpdate();  //step 4 and 5
           }
           
           //step 6 Closing down JDBC objects
           pstm.close();
           con.close();
           System.out.println("Information was inserted into table ");
       }catch(SQLException e) {
            System.out.println("Inserting  failed");
            e.printStackTrace(System.out);
            System.out.println("ErrorCode is: "+e.getErrorCode());
            System.out.println("SQLState is: "+ e.getSQLState());
       } catch(Exception e) {
             e.printStackTrace(System.out);
       }
   }
}
