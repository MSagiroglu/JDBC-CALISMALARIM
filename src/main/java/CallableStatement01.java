import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mustafa", "postgres", "musti123");
        Statement statement = connection.createStatement();

        //Method oluşturma ve onu çağırma işlemlerini Callable Statement ile yapacağız

        /*
        ÖRNEK-1 : SELAMLAMA YAPAN BİR FUNCTION OLUŞTURUP ÇALIŞTIRINIZ.
         */
        String sql = "CREATE OR REPLACE FUNCTION selamlama(x TEXT) RETURNS TEXT AS " +
                "$$ BEGIN RETURN 'Merhaba ' || x || ', nasılsın?'; " +
                "END; $$ LANGUAGE plpgsql;";
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
        CallableStatement callableStatement=connection.prepareCall("{? = call selamlama(?)}");
        //1. ? işareti için data türü belirtilmeli
        //1. ? işareti için girilecek olan parametre belirtilmeli.


        //4. adım : return için registerOutParameter() metodunu parametreler için setInt,setString gibi metodları kullanacağız.
        callableStatement.registerOutParameter(1,Types.VARCHAR);
        callableStatement.setString(2,"Ali");


        //5. adım :execute() metodu ile callableStatement'ı çalıştırırız.
        callableStatement.execute();

        //6. adım : sonucu  görmek için callableStatement'dan data türünü çağırıyoruz içindeki dönen
        //callableStatement'ta data resultSet içine alınmaz. Direk callableStatement'tan alınır.
        System.out.println(callableStatement.getString(1));















        connection.close();
        statement.close();
    }
}
