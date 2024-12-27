package fishingrod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldFishingRodTest {
    @Test
    public void testGoldFishingRodAttributes() {
        GoldFishingRod goldFishingRod = new GoldFishingRod();
        assertEquals("Gold Fishing Rod", goldFishingRod.getName());
        assertEquals(30, goldFishingRod.getPrice());
        assertEquals("GOLD", goldFishingRod.getGrade());
    }
}
