package az.iktlab.create.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnPostgresSQL {

    private static ConnPostgresSQL instance;
    private Connection connection;


    public static ConnPostgresSQL getInstance(String db) {
        try {
            if(instance == null || instance.getConnection().isClosed() ) {
                instance = new ConnPostgresSQL(db);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public ConnPostgresSQL(String db) {
        try{
            String url = String.format("jdbc:postgresql://localhost:5432/%s",db);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(
                            url,
                            "postgres",
                            "123456"
                    );
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error Connection: " + e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

