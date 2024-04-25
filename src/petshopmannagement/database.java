
package petshopmannagement;

//import java.sql.Connection;

import java.sql.*;

/**
 *
 * @author LENOVO
 */
public class database {
    public static Connection connectDb() throws ClassNotFoundException, SQLException
    {
     try{   
         Class.forName("com.mysql.jdbc.Driver");
         
         Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/pet","root","nayeem007$");
         return connection;
     }
    catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}
