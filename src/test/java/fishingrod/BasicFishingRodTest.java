package fishingrod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BasicFishingRodTest {

    @Test
    public void testBasicFishingRodAttributes() {
        BasicFishingRod basicFishingRod = new BasicFishingRod();
        assertEquals("Basic Fishing Rod", basicFishingRod.getName());
        assertEquals(10, basicFishingRod.getPrice());
        assertEquals("BASIC", basicFishingRod.getGrade());
    }
}
