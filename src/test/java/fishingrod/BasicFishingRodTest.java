package fishingrod;

import fish.CatFish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicFishingRodTest {
    @Test
    public void testBasicFishingRodAttributes() {
        BasicFishingRod basicFishingRod = new BasicFishingRod();
        assertEquals("Basic Fishing Rod", basicFishingRod.getName());
        assertEquals(10, basicFishingRod.getPrice());
        assertEquals("BASIC", basicFishingRod.getGrade());
    }
}
