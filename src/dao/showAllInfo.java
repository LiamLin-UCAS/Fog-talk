package dao;

import model.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class showAllInfo
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static User showAllInfo(String account)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String sql = "select * from user where account = '"
                    + account + "'";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            User user = new User();
            user.setUsername(rs.getString(2));
            user.setAccount(rs.getString(3));
            user.setPhone(rs.getString(4));
            user.setMailbox(rs.getString(5));
            user.setAge(rs.getInt(6));
            user.setSex(rs.getString(7));
            user.setSignature(rs.getString(8));

            return user;
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
