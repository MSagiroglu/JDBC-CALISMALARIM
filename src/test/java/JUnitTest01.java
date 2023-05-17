import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class JUnitTest01 {
    @Test
    public void test01(){
        assertEquals(1,1);// Bu metodun parantez içindeki parametreleri eşitt ise PASS olur değil ise FAIL olur.
        assertTrue("hello".contains("e"));// Bu metodun parantez içi true ise PASS olur değil ise FAIL olur.

    }
}
