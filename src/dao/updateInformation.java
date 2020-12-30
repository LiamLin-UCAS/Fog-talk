package dao;

import model.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class updateInformation
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean updateInformation(User user)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String sql = "update from user set username = ?,phone = ?,mailbox = ?,sex = ?,age = ?,signature = ? where account = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPhone());
            stmt.setString(3,user.getMailbox());
            stmt.setString(4,user.getSex());
            stmt.setInt(5,user.getAge());
            stmt.setString(6,user.getSignature());
            stmt.setString(7,user.getAccount());

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
