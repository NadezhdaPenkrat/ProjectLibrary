package applibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSourceUtil {

    private Connection connection;


    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/library",
                                "Nadezhda", "123456789");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
