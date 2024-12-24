package fish;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {

    @Test
    public void testFishAttributes() {
        Fish fish = new TestFish();
        assertEquals("Test Fish", fish.getName());
        assertEquals(50, fish.getGold());
        assertEquals("RARE", fish.getGrade());
    }
}