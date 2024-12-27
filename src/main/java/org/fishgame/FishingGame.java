package org.fishgame;

import java.util.Random;
import java.util.Scanner;

public class FishingGame {

    private final String[][] fishingGrid;
    private int gold;

    public FishingGame() {
        this.fishingGrid = new String[2][3]; // Ukuran grid 2x3
        this.gold = 20; // Inisialisasi gold
        populateGrid(); // Mengisi grid dengan ikan
    }

    // Display Menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Menu Fishing Game ===");
        System.out.println("Gold: " + gold);
        System.out.println("1. Fishing");
        System.out.println("2. Shop");
        System.out.println("3. Exit");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                displayGrid();
                break;
            case "2":
                System.out.println("shop");
                break;
            case "3":
                System.out.println("exit");
                // running = false;
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();

    }

    // Mengisi grid dengan ikan di posisi acak
    void populateGrid() {
        Random random = new Random();
        int fishRow = random.nextInt(2); // Baris acak
        int fishCol = random.nextInt(3); // Kolom acak
        for (String[] row : fishingGrid) {
            for (int j = 0; j < row.length; j++) {
                row[j] = "[ ]"; // Semua kotak kosong
            }
        }
        fishingGrid[fishRow][fishCol] = "[F]"; // Tempatkan ikan
    }

    // Menampilkan isi grid
    public void displayGrid() {
        System.out.println("A  B  C");
        for (int i = 0; i < fishingGrid.length; i++) {
            for (int j = 0; j < fishingGrid[i].length; j++) {
                System.out.print("[]"); // Menampilkan isi grid
            }
            System.out.println();
        }
    }

    public String[][] getGrid() {
        return fishingGrid;
    }

    public static void main(String[] args) {
        FishingGame game = new FishingGame();
        game.displayMenu(); // Menampilkan isi grid
    }

}
