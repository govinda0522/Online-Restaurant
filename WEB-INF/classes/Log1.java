import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class Log1 extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");
Scanner obj=new Scanner(System.in);
try
{
Class.forName("com.mysql.jdbc.Driver");
String s="jdbc:mysql://localhost:3306/5B1";
String s1="jdbc:mysql://127.0.0.1:3306/5B1?serverTimezone=UTC";
Connection con= DriverManager.getConnection(s1,"root","");
String mobno=req.getParameter("t1");
String pass=req.getParameter("t2");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from register");
int f=0;
while(rs.next())
{
if(rs.getString(4).equals(mobno) && rs.getString(2).equals(pass))
{
res.sendRedirect("http://localhost:8080/Online-Restaurant/soup6.html");
f=1;
break;
}
}
if(f==0)
{
res.sendRedirect("http://localhost:8080/Online-Restaurant/register4.html");
}
out.close();
}
catch(Exception e)
{
out.println(e);
}
}
}




