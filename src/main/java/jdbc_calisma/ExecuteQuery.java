package jdbc_calisma;

import java.sql.*;

public class ExecuteQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mustafa", "postgres", "musti.598");
        Statement statement = connection.createStatement();

        String sql1 = "Insert into countries values ('AR','Argentina',2);\n" +
                "Insert into countries values ('AU','Australia',3);\n" +
                "Insert into countries values ('BE','Belgium',1);\n" +
                "Insert into countries values ('BR','Brazil',2);\n" +
                "Insert into countries values ('CA','Canada',2);\n" +
                "Insert into countries values ('CH','Switzerland',1);\n" +
                "Insert into countries values ('CN','China',3);\n" +
                "Insert into countries values ('DE','Germany',1);\n" +
                "Insert into countries values ('DK','Denmark',1);\n" +
                "Insert into countries values ('EG','Egypt',4);\n" +
                "Insert into countries values ('FR','France',1);\n" +
                "Insert into countries values ('IL','Israel',4);\n" +
                "Insert into countries values ('IN','India',3);\n" +
                "Insert into countries values ('IT','Italy',1);\n" +
                "Insert into countries values ('JP','Japan',3);\n" +
                "Insert into countries values ('KW','Kuwait',4);\n" +
                "Insert into countries values ('ML','Malaysia',3);\n" +
                "Insert into countries values ('MX','Mexico',2);\n" +
                "Insert into countries values ('NG','Nigeria',4);\n" +
                "Insert into countries values ('NL','Netherlands',1);\n" +
                "Insert into countries values ('SG','Singapore',3);\n" +
                "Insert into countries values ('UK','United Kingdom',1);\n" +
                "Insert into countries values ('US','United States of America',2);\n" +
                "Insert into countries values ('ZM','Zambia',4);\n" +
                "Insert into countries values ('ZW','Zimbabwe',4);";
        int i = statement.executeUpdate(sql1);
        System.out.println("i = " + i);



        //int t=statement.executeUpdate("delete from countries;");
        //System.out.println("t = " + t);

        ResultSet result1 = statement.executeQuery("select * from countries where region_id=1;");
        while (result1.next()) {
            System.out.println(result1.getObject("country_id") + " --- " + result1.getObject(2) +
                    " --- " + result1.getObject("region_id"));


        }
    }
}
