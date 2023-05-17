import java.sql.*;

public class CallableStatement03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "musti.598");
        Statement statement = connection.createStatement();

        /*
        2. ÖRNEK :İKİ SAYIYI TOPLAYAN BİR FUNCTION YAZIN VE CALLABLE STATEMENT İLE ÇAĞIRINIZ
         */
        String sql = "CREATE OR REPLACE FUNCTION toplama (x INT,y INT)\n" +
                "RETURNS NUMERIC\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN X + Y;\n" +
                "END;\n" +
                "$$\n" +
                "LANGUAGE plpgsql;";
        statement.execute(sql);// function'u sql de oluşturduk

        CallableStatement callableStatement = connection.prepareCall("{? = call toplama(?,?) }"); // function'u  çağırıyoruz

        callableStatement.registerOutParameter(1, Types.NUMERIC); // bu 1. soru işareti için işlemle ne return edeceğini söylüyoruz.
        callableStatement.setInt(2, 6);// 2. soru işareti için int set edip ne olduğunu söyledik
        callableStatement.setInt(3, 4);// 3. soru işareti için int set edip ne olduğunu söyledik

        callableStatement.execute(); //callable statement i çalıştırıyoruz

        System.out.println("Toplama fonksiyonu sonrası sonuç : "+callableStatement.getBigDecimal(1));//verilen parametreler sonucu fonsiyonun oluşturduğu sonucu yazdırıyoruz.
    }
}
