package fish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TunaTest {
    @Test
    public void testTunaAttributes() {
        Tuna tuna = new Tuna();
        assertEquals("Tuna", tuna.getName());
        assertEquals(30, tuna.getGold());
        assertEquals("UNCOMMON", tuna.getGrade());
    }
}