//dbConnection
// 

package objectmanagement;

import java.sql.*;


public class dbConnection {

private static final String URL = "jdbc:mysql://localhost/openoccasion?autoReconnect=true&useSSL=false";
private static final String LOGIN = "openoccas";
private static final String PASSWORD = "openoccas";
private static dbConnection connector;
private static Connection connection;

public dbConnection() {
}

public synchronized static dbConnection getInstance() {
    if (connector == null) {
        connector = new dbConnection();
    }
    return connector;
}

public static Connection getConnection() {
    if (connection == null) {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return c;
    }
    return connection;
}

}

