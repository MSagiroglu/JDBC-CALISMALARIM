import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        Statement statement = connection.createStatement();
        System.out.println("*********************ÖRNEK - 1***************************");
        //1.YOL : OFFSET ve LIMIT kullanarak çözüm.
        String sql1="SELECT company , number_of_employees FROM companies ORDER BY number_of_employees desc offset 1 limit 1;";
        ResultSet resultSet=statement.executeQuery(sql1);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1) + " --- " + resultSet.getObject(2));
        }
        //2.YOL : SUBQUERY kullanarak çözüm.
        System.out.println("2.YOL : SUBQUERY kullanarak çözüm.");
        String sql2="SELECT company , number_of_employees FROM companies WHERE number_of_employees = (SELECT MAX(number_of_employees) FROM companies \n" +
                "WHERE number_of_employees<(SELECT MAX(number_of_employees) FROM companies));";
        ResultSet resultSet2=statement.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getObject(1) + " --- " + resultSet2.getObject(2));
        }
        connection.close();
        statement.close();
        //class acik kalirsa bulut sistemi ile baglanti halinde ekstra ucret odemek zorunda kalabiliriz.
    }
}
