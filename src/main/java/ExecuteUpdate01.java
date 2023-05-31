import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından
        // az olan number_of_employees değerlerini 16000 olarak UPDATE edin.
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        Statement statement = connection.createStatement();
        System.out.println("*********************ÖRNEK - 1***************************");
        String sql1 = "UPDATE companies SET number_of_employees = 16000 WHERE number_of_employees <(SELECT AVG(number_of_employees) FROM companies)";
        int updateEdilenSatirSayisi = statement.executeUpdate(sql1);
        System.out.println("updateEdilenSatirSayisi = " + updateEdilenSatirSayisi);

        //update sonrası listeleme işlemi
        Statement statement2 = connection.createStatement();
        String sql2 = "SELECT * FROM companies;";
        ResultSet resultSet2 = statement2.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getObject(1) + " --- " + resultSet2.getObject(2) + " --- " + resultSet2.getObject(3));

            connection.close();
            statement.close();
            //class acik kalirsa bulut sistemi ile baglanti halinde ekstra ucret odemek zorunda kalabiliriz.
        }
    }
}
