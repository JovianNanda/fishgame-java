package org.fishgame;

import java.util.Random;

public class FishingGame {

    private final String[][] fishingGrid;

    public FishingGame() {
        this.fishingGrid = new String[2][2]; // Ukuran grid 2x
    }

    // Mengisi grid dengan ikan di posisi acak
    void populateGrid() {
        Random random = new Random();
        int fishRow = random.nextInt(2); // Baris acak
        int fishCol = random.nextInt(2); // Kolom acak
        for (String[] row : fishingGrid) {
            for (int j = 0; j < row.length; j++) {
                row[j] = "[ ]"; // Semua kotak kosong
            }
        }
        fishingGrid[fishRow][fishCol] = "[F]"; // Tempatkan ikan
    }

    // Menampilkan isi grid
    public void displayGrid() {
        System.out.println("A B");
        for (int i = 0; i < fishingGrid.length; i++) {
            for (int j = 0; j < fishingGrid[i].length; j++) {
                System.out.print("[ ] "); // Kotak kosong
            }
            System.out.println();
        }
    }
    
    public String[][] getGrid() {
        return fishingGrid;
    }

    public static void main(String[] args) {
        FishingGame game = new FishingGame();
        game.displayGrid(); // Menampilkan isi grid
    }

}
