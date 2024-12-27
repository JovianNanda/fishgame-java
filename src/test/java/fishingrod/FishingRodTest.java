package fishingrod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishingRodTest {
    @Test
    public void testFishingRodAttributes() {
        FishingRod fishingRod = new TestFishingRod();
        assertEquals("Test Fishing Rod", fishingRod.getName());
        assertEquals(10, fishingRod.getPrice());
        assertEquals("BASIC", fishingRod.getGrade());
    }
}

