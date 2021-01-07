package dao;

import model.Comment;
import model.Post;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class showComment
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static Comment[] showComment(String postId)
    {
        try
        {
            con = JDBCUtils.getConnection();
            Comment[] comments = new Comment[200];
            Comment comment;

            String sql = "select * from comment where postid = '" + postId +  "'";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            int number = 0;
            while(rs.next())
            {
                comment = new Comment();

                comment.setContent(rs.getString(2));
                comment.setPublisher(rs.getString(3));
                comment.setReleaseTime(rs.getString(4));

                comments[number] = comment;
                number++;
            }

            return comments;
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
