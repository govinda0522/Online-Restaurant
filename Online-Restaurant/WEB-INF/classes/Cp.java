
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class Cp extends HttpServlet
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
String opass=req.getParameter("t2");
String npass=req.getParameter("t3");
String q="update register set password=? where mobileno=?";
PreparedStatement ps=con.prepareStatement(q);
int f=0;
ps.setString(1,npass);
ps.setString(2,mobno);
f=ps.executeUpdate();
if(f==0)
{
out.println("<body style=\"background-image:url('vote10.jpg');background-repeat:no-repeat;background-size:100% 100%;\"><center><font color='yellow'>password change unsuccessful</h1></center>");
}
else
{
out.println("<center><h1><font color='yellow'>password change successful</h1></center><body style=\"background-image:url('vote10.jpg');background-repeat:no-repeat;background-size:100% 100%;\">");
}
}
catch(Exception e)
{
out.println(e);
}
}
}





