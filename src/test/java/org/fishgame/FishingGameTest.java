package org.fishgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FishingGameTest {

    private FishingGame fishingGame = new FishingGame();

    @Test
    public void testPopulateGrid() {
        fishingGame.populateGrid();
        assertNotNull(fishingGame.getGrid());
        assertTrue(fishingGame.getGrid().length > 0, "Grid should not be empty");
    }

    @Test
    public void testDisplayGrid() {
        fishingGame.populateGrid();
        fishingGame.displayGrid();
        assertNotNull(fishingGame.getGrid(), "Grid should not be null");
    }
}
