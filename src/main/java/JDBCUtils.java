import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    //BU CLASS 'DA TEKRARLI KULLANILACAK METOTLAR OLUŞTURACAĞIZ
    private static Connection connection;//static olmalı ki static metodun içinde kullanabileyim.
    //private yaptık ki sadece bu class daki metodlar ulaşabilsin diğer classlar ulaşamasın.

    private static Statement statement;



    //1. DATABASE'E BAĞLANMA METODU --> Connection return eder
    public static Connection connecToDatabase (){//parametre vererek database i başka yollarlada belirleyebiliriz
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    // STATEMENT OLUŞTURMA METODU --> Statement return eder
    public static Statement createStatement(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    //execute() METODU İLE QUERY ÇALIŞTIRAN METHOD
    public static boolean execute(String sql){
        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //executeQuery() METODU İLE QUERY ÇALIŞTIRAN METHOD
    //executeUpdate() METODU İLE QUERY ÇALIŞTIRAN METHOD




}
