package web;

import com.alibaba.fastjson.JSONObject;
import model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static dao.addNewComment.addNewComment;

@WebServlet ("/addComment")
public class addComment extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        /*
        第一步:获取帖子的id以及评论的相关内容
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

        String postId = req.getParameter("postId");

        /*
        第二步:构建评论comment对象
         */

        Comment comment = new Comment();

        comment.setContent(content);
        comment.setPublisher(publisher);
        comment.setReleaseTime(releaseTime);
        comment.setPostId(postId);

        /*
        第三步:把新的评论添加到数据库，并返回结果状态
         */

        boolean judge = addNewComment(comment);

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
