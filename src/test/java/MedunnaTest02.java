import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedunnaTest02 {
@Test
    public void medunnaTest2() throws SQLException {


    JDBCUtils.connectToMedunnaDataBase();
    JDBCUtils.createStatement();
    JDBCUtils.createStatement();
    String sql="select * from room where room_number=9995033; ";
    ResultSet resultSet=JDBCUtils.executeQuery(sql);
    resultSet.next();
    assertEquals("123.00",resultSet.getString("price"));
    assertTrue(resultSet.getString("price").equals("123.00"));



    JDBCUtils.closeConnection();
}
}
