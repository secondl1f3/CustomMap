import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomMapTest {
    private NewMap<String, String> newMap;

    @Before
    public void setUp() throws Exception {
        newMap = new NewMap<String, String>();
    }

    @Test
    public void getSizeTest() throws Exception {
        newMap.put("Indonesia", "Jakarta");
        assertEquals(newMap.size(), 1);
    }

    @Test
    public void getValueTest() throws Exception {
        newMap.put("Indonesia", "Jakarta");
        String expResult = "Jakarta";
        String result = newMap.get("Indonesia");
        assertEquals(expResult, result);
    }

    @Test
    public void putValueTest() throws Exception {
        newMap.put("Poland", "Krakow");
        String expResult = "Krakow";
        String result = newMap.put("Poland", "Krakow");
        assertEquals(expResult, result);
    }

    @Test
    public void searchKey() throws Exception {
        newMap.put("Indonesia", "Manila");
        assertTrue(newMap.containsKey("Indonesia"));
        assertTrue(newMap.containsValue("Manila"));
    }

    @Test
    public void emptyTest() throws Exception {
        assertTrue(newMap.isEmpty());
    }

    @Test
    public void emptyTestWithValue() throws Exception {
        newMap.put("key", "value");
        assertFalse(newMap.isEmpty());
    }
}
