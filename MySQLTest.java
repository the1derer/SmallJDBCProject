// create user 'shubham'@'localhost' identified by 'Mysql123';
// Class.forName("com.mysql.jdbc.Driver");
// Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl","shubham","Mysql123");

// Class.forName("com.mysql.cj.jdbc.Driver");
// DriverManager.getConnection("jdbc:mysql://localhost/orcl?" + "user=shubham&password=Mysql123");

// Loading class `com.mysql.jdbc.Driver'. This is deprecated.
// The new driver class is `com.mysql.cj.jdbc.Driver'.
// The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
// Fri Aug 10 23:15:18 IST 2018 WARN: Establishing SSL connection without server's identity verification is not recommended.
// According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set.
// For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'.
// You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
import java.sql.*;
import java.io.*;

class Temp
{
    public static void main(String s1[])
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl","shubham","Mysql123");
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select * from emp101");
            while(rs.next())
            {
                System.out.print(rs.getString(1)+"  ");
                System.out.println(rs.getString(2));
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}