package web;

import com.alibaba.fastjson.JSONObject;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static dao.searchMessage.searchMessage;

@WebServlet("/searchPost")
public class searchPost extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String message = req.getParameter("message"); //搜索信息

        Post[] posts = searchMessage(message);

        int postsLength = 0;
        while (posts[postsLength] != null) postsLength++;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("posts",posts);
        jsonObject.put("postsLength",postsLength);

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
