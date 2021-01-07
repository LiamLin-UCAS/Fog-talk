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

import static dao.showAllInfo.showAllInfo;

@WebServlet("/showInfo")
public class showInfo extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String account = req.getParameter("account");

        User user = showAllInfo(account);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);

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
