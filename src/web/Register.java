package web;

import model.User;
import com.alibaba.fastjson.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static dao.registerNewUser.registerNewUser;

@WebServlet("/register")
public class Register extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        /*
        第一步:获取注册信息
         */

        //解决姓名乱码问题
        String username = new String(
                req.getParameter("username").getBytes("iso-8859-1"),"UTF-8"
        );

        String account = req.getParameter("account");

        String phone = req.getParameter("phone");

        String mailbox = req.getParameter("mailbox");

        //解决性别乱码问题
        String sex = new String(
                req.getParameter("sex").getBytes("iso-8859-1"),"UTF-8"
        );

        int age = Integer.parseInt(req.getParameter("age"));

        //解决个性签名乱码问题
        String signature = new String(
                req.getParameter("signature").getBytes("iso-8859-1"),"UTF-8"
        );

        String password = req.getParameter("password");

        /*
        第二步:创建user用户，传给注册用户的函数，完成注册
         */

        User user = new User();

        user.setUsername(username);
        user.setAccount(account);
        user.setPhone(phone);
        user.setMailbox(mailbox);
        user.setAge(age);
        user.setSex(sex);
        user.setSignature(signature);
        user.setPassword(password);

        /*
        第三步:注册新用户信息，并返回结果状态
         */

        boolean judge = registerNewUser(user);

        /*
        返回给客户端响应
         */

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("judge",judge);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        try
        {
            out.println(jsonObject);
            out.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
