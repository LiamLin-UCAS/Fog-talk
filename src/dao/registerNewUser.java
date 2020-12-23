package dao;

import model.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class registerNewUser
{
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static boolean registerNewUser(User user)
    {
        try
        {
            con = JDBCUtils.getConnection();

            String username = user.getUsername();
            String account = user.getAccount();
            String phone = user.getPhone();
            String mailbox = user.getMailbox();
            int age = user.getAge();
            String sex = user.getSex();
            String signature = user.getSignature();
            String password = user.getPassword();

            String sql1 = "select * from user where account = ? or username = ?";
            stmt = con.prepareStatement(sql1);

            stmt.setString(1,account);
            stmt.setString(2,username);

            rs = stmt.executeQuery();
            if(rs.next()) return false;

            String sql2 = "insert into user(account,username,password,mailbox,phone,age," +
                    "sex,signature) values(?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql2);

            stmt.setString(1,account);
            stmt.setString(2,username);
            stmt.setString(3,password);
            stmt.setString(4,mailbox);
            stmt.setString(5,phone);
            stmt.setInt(6,age);
            stmt.setString(7,sex);
            stmt.setString(8,signature);

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
