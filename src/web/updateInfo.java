package web;

import com.alibaba.fastjson.JSONObject;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static dao.updateInformation.updateInformation;

@WebServlet ("/updateInfo")
public class updateInfo extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        /*
        第一步:获取用户的更新信息
         */

        //账号负责选择是哪个用户信息的更改
        String account = req.getParameter("account");

        String username = new String(req.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
        String phone = req.getParameter("phone");
        String mailbox = req.getParameter("mailbox");
        String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"),"UTF-8");
        int age = Integer.parseInt(req.getParameter("age"));
        String signature = new String(req.getParameter("signature").getBytes("iso-8859-1"),"UTF-8");

        /*
        第二步:创建用户对象
         */

        User user = new User();

        user.setAccount(account);
        user.setUsername(username);
        user.setPhone(phone);
        user.setMailbox(mailbox);
        user.setSex(sex);
        user.setAge(age);
        user.setSignature(signature);

        /*
        第三步:更新用户信息，并返回判断结果
         */

        boolean judge = updateInformation(user);

        /*
        第四步:返回给客户端响应
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
