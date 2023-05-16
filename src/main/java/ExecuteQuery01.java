import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        Statement statement = connection.createStatement();
        System.out.println("*********************ÖRNEK - 1***************************");
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
        System.out.println("*********************ÖRNEK - 2***************************");
        // 2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql2="SELECT country_id, country_name FROM countries WHERE region_id>2;";
        ResultSet resultSet2=statement.executeQuery(sql2);

        while(resultSet2.next()){
            System.out.println(resultSet2.getString(1) + " --- " + resultSet2.getString(2));
        }
        System.out.println("*********************ÖRNEK - 3***************************");
        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3="SELECT * FROM companies WHERE number_of_employees=( SELECT MIN (number_of_employees) FROM companies );";
        ResultSet resultSet3=statement.executeQuery(sql3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getObject(1) + " --- " + resultSet3.getObject(2) + " --- " + resultSet3.getObject(3));
            //matematik işlemleri yapacak isek  aşağıdaki şekilde kullanmalıyız.
            System.out.println(resultSet3.getInt(1) + " --- " + resultSet3.getObject(2) + " --- " + resultSet3.getInt(3));}
        connection.close();
        statement.close();
       // class acik kalirsa bulut sistemi ile baglanti halinde ekstra ucret odemek zorunda kalabiliriz.
    }
}
