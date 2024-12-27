package fishingrod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamondFishingRodTest {
    @Test
    public void testDiamondFishingRodAttributes() {
        DiamondFishingRod diamondFishingRod = new DiamondFishingRod();
        assertEquals("Diamond Fishing Rod", diamondFishingRod.getName());
        assertEquals(100, diamondFishingRod.getPrice());
        assertEquals("DIAMOND", diamondFishingRod.getGrade());
    }
}
