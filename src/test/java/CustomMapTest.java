import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomMapTest {

    @Test
    public void testCustomMap() {
        CustomMap<String, String> customMap = new CustomMap<>(3);
        customMap.put("Philippines", "Manila");
        customMap.put("Poland", "Krakow");
        customMap.put("India", "New Delhi");
        customMap.put("Indonesia", "Jakarta");

        assertNotNull(customMap);
        assertEquals(4, customMap.size());
        assertEquals("Krakow", customMap.get("Poland"));
        assertEquals("Jakarta", customMap.get("Indonesia"));
    }
}
