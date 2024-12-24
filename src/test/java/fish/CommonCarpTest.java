package fish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonCarpTest {
    @Test
    public void testCommonCarpAttributes() {
        CommonCarp commoncarp = new CommonCarp();
        assertEquals("Common Carp", commoncarp.getName());
        assertEquals(10, commoncarp.getGold());
        assertEquals("COMMON", commoncarp.getGrade());
    }
}