package dao;

import model.Post;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addNewPost
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean addNewPost(Post post)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String sql = "insert into post(content,publisher,releaseTime)" +
                    "values(?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,post.getContent());
            stmt.setString(2,post.getPublisher());
            stmt.setString(3,post.getReleaseTime());

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
