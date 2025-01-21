package fish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordfishTest {
    @Test
    public void testSwordfishAttributes() {
        Swordfish swordfish = new Swordfish();
        assertEquals("Swordfish", swordfish.getName());
        assertEquals(150, swordfish.getGold());
        assertEquals("LEGENDARY", swordfish.getGrade());
    }
}