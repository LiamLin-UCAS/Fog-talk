package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            // ServletException, IOException
    {
        String name = req.getParameter("name");
        //解决姓名乱码问题
        //String Name = new String(name.getBytes("iso-8859-1"),"UTF-8");
        String userid = req.getParameter("userid");
        String major = req.getParameter("major");
        //解决专业乱码问题
        //String Major = new String(major.getBytes("iso-8859-1"),"UTF-8");
        String phone = req.getParameter("phone");
        String mailbox = req.getParameter("mailbox");
        String password = req.getParameter("password1");
    }
}
