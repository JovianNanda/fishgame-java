package fish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedSnapperTest {
    @Test
    public void testRedSnapperAttributes() {
        RedSnapper redsnapper = new RedSnapper();
        assertEquals("Red Snapper", redsnapper.getName());
        assertEquals(50, redsnapper.getGold());
        assertEquals("RARE", redsnapper.getGrade());
    }
}