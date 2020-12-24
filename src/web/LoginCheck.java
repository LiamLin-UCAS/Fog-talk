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

import static dao.loginCheckUser.loginCheckUser;

@WebServlet ("/loginCheck")
public class LoginCheck extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        /*
        第一步:获取登录信息
         */

        String account = req.getParameter("account");

        String password = req.getParameter("password");

        /*
        第二步:创建用户对象将信息放入
         */

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);

        /*
        第三步:进行身份验证
         */

        boolean judge = loginCheckUser(user);

        /*
        第四步:把结果发还给前端
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
