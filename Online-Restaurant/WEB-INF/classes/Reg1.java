import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class Reg1 extends HttpServlet
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
String name=req.getParameter("t1");
String pass=req.getParameter("t2");
String email=req.getParameter("t3");
String mobno=req.getParameter("t4");
String q="insert into Register values(?,?,?,?)";
PreparedStatement ps=con.prepareStatement(q);
ps.setString(1,name);
ps.setString(2,pass);
ps.setString(3,email);
ps.setString(4,mobno);
int n=0;
n=ps.executeUpdate();
if(n==0)
out.println("<h1><font color=\"red\"> Registration failed </h1></font></center>");
else
{
res.sendRedirect("http://localhost:8080/Online-Restaurant/register3.html");
out.println("<center><h1><font color=\"red\">Successfully Registered " +name+"</h1></font></center>");
}
con.close();
}
catch(Exception e)
{
	//out.println(e);
out.println("<center><h1><font color=\"blue\">already registered with this mobile number </h1></font></center>");
}
}
}





