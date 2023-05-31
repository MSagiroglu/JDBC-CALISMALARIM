import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Database 'e bağlanma
        //1. Adım: Driver'a kaydol ==> JDBC 4 sonrası gerek yoktur
        Class.forName("org.postgresql.Driver");

        //2. Adım:Database 'e bağlanma
        Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");

        //3. Adım: Staement oluşturma
        Statement statement = connection.createStatement();

        //4. Adım: Query çaılştırma
         /*
        1) Eğer execute() methodu DDL (create, drop, alter table) ile kullanılırsa her zaman 'false' döner.
        2) Eğer execute() methodu DQL (select) ile kullanılırsa data dönerse 'true', data dönmezse 'false' döner.
         */

        //1. ÖRNEK: workers adında bir table oluşturunuz.
        // CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);

        boolean sql1 = statement.execute("CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);");
        // İşlem gerçekleştiği için "sql1 = false" döndü.
        System.out.println("sql1 = " + sql1);

        //2. ÖRNEK: workers table'ına workers_address adında bir sütun  oluşturunuz.
        String sqlQuery1 = "ALTER TABLE workers ADD workers_address VARCHAR(100);";
        boolean sql2 = statement.execute(sqlQuery1); // İşlem gerçekleştiği için "sql2 = false" döndü.
        System.out.println("sql2 = " + sql2);

        //3. ÖRNEK: workers table'ını siliniz

       //String sqlQuery2 = "DROP TABLE workers;";
       //boolean sql3 = statement.execute(sqlQuery2);// İşlem gerçekleştiği için "sql3 = false" döndü.
       //System.out.println("sql3 = " + sql3);

        //5. Adım: Bağlantıyı kapatma
        connection.close();
        statement.close();

    }
}
