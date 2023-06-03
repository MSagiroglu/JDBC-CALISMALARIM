import java.sql.*;

public class JDBCUtils {
    //BU CLASS 'DA TEKRARLI KULLANILACAK METOTLAR OLUŞTURACAĞIZ
    private static Connection connection;//static olmalı ki static metodun içinde kullanabileyim.
    //private yaptık ki sadece bu class daki metodlar ulaşabilsin diğer classlar ulaşamasın.
    private static Statement statement;
    private static ResultSet resultSet;


    //1. DATABASE'E BAĞLANMA METODU --> Connection return eder
    public static Connection connecToDatabase() {//parametre vererek database i başka yollarlada belirleyebiliriz
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mustafa", "postgres", "musti123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //1. MEDUNNA DATABASE'E BAĞLANMA METODU --> Connection return eder
    public static Connection connectToMedunnaDataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    // STATEMENT OLUŞTURMA METODU --> Statement return eder
    public static Statement createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    //execute() METODU İLE QUERY ÇALIŞTIRAN METHOD
    public static boolean execute(String sql) {
        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //executeQuery() methodu ile Query çalıştıran method
    public static ResultSet executeQuery(String sql) {

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    //executeUpdate() METODU İLE QUERY ÇALIŞTIRAN METHOD
    public static int executeUpdate(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Bağlantıyı kapatan method
    public static void closeConnection() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
