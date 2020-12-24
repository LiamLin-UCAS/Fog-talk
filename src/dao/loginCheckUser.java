package dao;

import model.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginCheckUser
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean loginCheckUser(User user)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String account = user.getAccount();
            String password = user.getPassword();

            String sql1 = "select * from user where account = ? and password = ?";
            stmt = con.prepareStatement(sql1);

            stmt.setString(1,account);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            //判断信息是否有重复
            if(rs.next()) return true;
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
