package dao;

import model.Comment;
import model.Post;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static dao.showComment.showComment;

public class displayAllPost
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static Post[] displayAllPost()
    {
        try
        {
            con = JDBCUtils.getConnection();
            Post[] posts = new Post[200];
            Post post;

            String sql1 = "select * from post";
            stmt = con.prepareStatement(sql1);

            rs = stmt.executeQuery();

            int number = 0;
            while(rs.next())
            {
                post = new Post();

                post.setPostId(rs.getString(1));
                post.setContent(rs.getString(2));
                post.setPublisher(rs.getString(3));
                post.setReleaseTime(rs.getString(4));
                post.setName(rs.getString(5));

                Comment[] comments = showComment(post.getPostId());

                post.setComments(comments);

                int length = 0;
                while (comments[length] != null) length++;

                post.setCommentsLength(length);

                posts[number] = post;
                number++;
            }

            return posts;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.close(rs, stmt, con);
        }

        return null;
    }
}
