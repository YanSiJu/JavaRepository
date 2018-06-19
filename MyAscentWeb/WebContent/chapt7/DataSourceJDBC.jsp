<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<html>
<head>
<title>Basic JDBC JSP</title>
</head>
<body bgcolor="#ffffff">
<h2>Employees in London</h2>
<table border="1" width="90%">
<tr>
<td width="20%">username</td><td width="80%">title</td>
</tr>
<%
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;

   try{
//      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 //     conn=DriverManager.getConnection("jdbc:odbc:northwind","","");

      Context ctx=(Context)new InitialContext();
      DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ascentweb");
      conn=ds.getConnection();
      
      stmt=conn.createStatement();
      rs=stmt.executeQuery("select username,title from usr ");
      int rowNum=0;
      while(rs.next()){
         rowNum++;
         String title=rs.getString("title");
         String username=rs.getString("username");
%>
<tr>
    <td><%=username%></td><td><%=title%></td>
<%  }%>
</table>
<%
    }catch(Exception e){
      out.println(e.getMessage());
    }finally{
       try{
          if(rs!=null)
            rs.close();
          if(stmt!=null)
            stmt.close();
          if(conn!=null)
            conn.close();
       }catch(SQLException sqle){
          out.println(sqle.getMessage());
       }
    }
%>
</body>
</html>
