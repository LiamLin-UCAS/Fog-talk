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
import java.nio.charset.StandardCharsets;

import static dao.addNewPost.addNewPost;

@WebServlet ("/addPost")
public class addPost extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        /*
        第一步:获取要添加的帖子的全部信息
         */

        String content = new String(
                req.getParameter("content").getBytes("iso-8859-1"),"UTF-8"
        );

        String publisher = new String(
                req.getParameter("publisher").getBytes("iso-8859-1"),"UTF-8"
        );

        String releaseTime = new String(
                req.getParameter("releaseTime").getBytes("iso-8859-1"),"UTF-8"
        );

        String name = new String(
                req.getParameter("name").getBytes("iso-8859-1"),"UTF-8"
        );

        /*
        第二步:构建帖子post对象
         */

        Post post = new Post();

        post.setContent(content);
        post.setPublisher(publisher);
        post.setReleaseTime(releaseTime);
        post.setName(name);

        /*
        第三步:把新的帖子添加到数据库，并返回结果状态
         */

        boolean judge = addNewPost(post);

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
