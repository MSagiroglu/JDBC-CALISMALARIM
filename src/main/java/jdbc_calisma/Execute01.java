package jdbc_calisma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");// jdbc 4 sonrası gerek yok

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mustafa", "postgres", "musti.598");
        Statement statement=connection.createStatement();


     boolean sql1= statement.execute("CREATE TABLE countries\n" +
              "(\n" +
              "    country_id CHAR(3),\n" +
              "    country_name VARCHAR(50),\n" +
              "    region_id SMALLINT\n" +
              ");");
     boolean sql2=statement.execute("Alter table countries drop column country_name;");

        boolean sql3=statement.execute("drop table countries;");


        System.out.println("sql1 = " + sql1);
        System.out.println("sql2 = " + sql2);
        System.out.println("sql3 = " + sql3);

        //statement.execute("drop table countries;");
        connection.close();
        statement.close();

    }
}
