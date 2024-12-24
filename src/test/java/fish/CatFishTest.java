package fish;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatFishTest {
    @Test
    public void testCatFishAttributes() {
        CatFish catFish = new CatFish();
        assertEquals("Cat Fish", catFish.getName());
        assertEquals(20, catFish.getGold());
        assertEquals("UNCOMMON", catFish.getGrade());
    }
}