package fishingrod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatinumFishingRodTest {
    @Test
    public void testPlatinumFishingRodAttributes() {
        PlatinumFishingRod platinumFishingRod = new PlatinumFishingRod();
        assertEquals("Platinum Fishing Rod", platinumFishingRod.getName());
        assertEquals(65, platinumFishingRod.getPrice());
        assertEquals("PLATINUM", platinumFishingRod.getGrade());
    }
}
