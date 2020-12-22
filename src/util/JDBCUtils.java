package util;

import java.sql.*;

public class JDBCUtils
{
    private static final String connectionURL = "jdbc:mysql://localhost:3306/management_system?"
            + "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String username = "胖聪一号";
    private static final String password = "lyc2959747634@@@";

    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(connectionURL, username, password);
        }
        catch (Exception e)
        {
            System.out.println("服务器连接出现异常");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static void close(ResultSet rs, Statement stmt, Connection con)
    {
        try
        {
            if (rs != null)
                rs.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            if (stmt != null)
                stmt.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            if (con != null)
                con.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection con)
    {
        try
        {
            if (rs != null)
                rs.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            if (pstmt != null)
                pstmt.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            if (con != null)
                con.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
