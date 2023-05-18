import jdk.dynalink.linker.LinkerServices;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Given
User connects to the database
(Kullanıcı veritabanına bağlanır)

When
User sends the query to get the region ids from "countries" table
(Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )

Then
Assert that the number of region ids greater than 1 is 17.
(1'den büyük region id'lerin sayısının 17 olduğunu doğrula )

And
User closes the connection
*/
public class CountryTest {
    @Test
    public void countryTest() throws SQLException {//Test metodlarının parametreleri olmaz!!!

        //User connect to the databaase
        JDBCUtils.connecToDatabase();
        JDBCUtils.createStatement();

        //User send the query to get the region ids from"countries" table
        String sql="SELECT COUNT (region_id) FROM countries WHERE region_id >1;";
        ResultSet resultSet=JDBCUtils.executeQuery(sql);

        //Assert that the number of region ids greater than 1 is 17.
        int number=0;
        while(resultSet.next()){
            number=resultSet.getInt(1);
        }
        assertEquals(17,number);
        //User close connection
        JDBCUtils.closeConnection();

    }

    @Test
    public void countryTest2 () throws SQLException {
        //User connect to the databaase
        JDBCUtils.connecToDatabase();
        JDBCUtils.createStatement();

        //User send the query to get the region ids from"countries" table
        String sql="SELECT region_id FROM countries WHERE region_id >1;";
        ResultSet resultSet=JDBCUtils.executeQuery(sql);
        List<Integer> region_idList=new ArrayList<>();
        while (resultSet.next()){//resultSet ten aldığım sayıları regionidList'e ekliyorum
            region_idList.add(resultSet.getInt(1));
        }
        System.out.println("region_idList = " + region_idList);//[2, 3, 2, 2, 3, 4, 4, 3, 3, 4, 3, 2, 4, 3, 2, 4, 4]

        //Assert that the number of region ids greater than 1 is 17
        assertEquals(17,region_idList.size());//resultidList eleman saysısı 17 olmalıdır

        //User close connection
        JDBCUtils.closeConnection();
    }
}
