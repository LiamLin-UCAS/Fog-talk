package dao;

import model.Comment;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addNewComment
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean addNewComment(Comment comment)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String sql = "insert into comment(content,publisher,releaseTime,postId)" +
                    "values(?,?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,comment.getContent());
            stmt.setString(2,comment.getPublisher());
            stmt.setString(3,comment.getReleaseTime());
            stmt.setString(4,comment.getPostId());

            int number = stmt.executeUpdate();
            if(number != 0) return true;
            else return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.close(rs, stmt, con);
        }

        return false;
    }
}
