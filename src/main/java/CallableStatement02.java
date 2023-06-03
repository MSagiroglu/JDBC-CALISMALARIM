import java.sql.*;

public class CallableStatement02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mustafa", "postgres", "musti123");
        Statement statement = connection.createStatement();

        //Method oluşturma ve onu çağırma işlemlerini Callable Statement ile yapacağız
         /*
        ÖRNEK-1 : SELAMLAMA YAPAN BİR FUNCTION OLUŞTURUP ÇALIŞTIRINIZ.
         */
        String sql = "CREATE OR REPLACE FUNCTION calculate_average(param1 INT, param2 INT)\n" +
                "RETURNS DECIMAL\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "    \n" +
                "    RETURN (param1+param2)/2;\n" +
                "END;\n" +
                "$$\n" +
                "LANGUAGE plpgsql;";
        //2. adım function kodunu çalıştırma
        statement.execute(sql);

//        String sql2="SELECT selamlama('Ali');";
//        ResultSet resultSet=statement.executeQuery(sql2);
//        resultSet.next();
//        System.out.println(resultSet.getObject(1));


         /*
        ÖRNEK -2 : SELAMALAMA YAPAN BİR FUNCTION'U CALLABLE STATEMENT İLE ÇAĞIRINIZ
         */

        // 3. adım : functionu çağırma
        java.sql.CallableStatement callableStatement=connection.prepareCall("{?= call calculate_average(?,?)}");


        //4. adım : return için registerOutParameter() metodunu parametreler için setInt,setString gibi metodları kullanacağız.
        callableStatement.registerOutParameter(1, Types.DECIMAL);
        callableStatement.setInt(2,10);
        callableStatement.setInt(3,30);


        //5. adım :execute() metodu ile callableStatement'ı çalıştırırız.
        callableStatement.execute();

        //6. adım : sonucu  görmek için callableStatement'dan data türünü çağırıyoruz içindeki dönen
        //callableStatement'ta data resultSet içine alınmaz. Direk callableStatement'tan alınır.
        System.out.println(callableStatement.getBigDecimal(1));
    }
}
