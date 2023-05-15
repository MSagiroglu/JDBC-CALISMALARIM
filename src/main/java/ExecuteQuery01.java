import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        Statement statement = connection.createStatement();

        //1. Örnek: region_id = 1 olan "country_name" değerlerini yazdırın
        String sql1="select country_name from countries where region_id=1;";
        boolean r1=statement.execute(sql1);
        System.out.println("r1 : " + r1);

        //SAtırları görmek için executeQuery() metodunu kullamnalıyız. execute() metodu sadece true ve false döner.

        // execute methodu sadece istedigim veriyi vermez hep true verir.
        // specific veriyi cagiramam. Bu yüzden uygun degil.
        // Saglikli, dogru data almak icin ExecuteQuery kullanmaliyiz.

        ResultSet resultSet=statement.executeQuery(sql1);
        //resultSet.next() ==> eğer sonraki satır varsa true döndürür.
        while (resultSet.next()){
            System.out.println(resultSet.getString("country_name"));

        }

    }
}
