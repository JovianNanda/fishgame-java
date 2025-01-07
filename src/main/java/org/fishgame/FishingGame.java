package org.fishgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import fish.CatFish;
import fish.CommonCarp;
import fish.Fish;
import fish.RedSnapper;
import fish.Swordfish;
import fish.Tuna;

public class FishingGame {

    private final String[][] fishingGrid;
    private int gold;
    private final Scanner scanner = new Scanner(System.in);
    private final int fishingGridRow = 2;
    private final int fishingGridCol = 3;
    private Fish fishInGrid;

    public FishingGame() {
        this.fishingGrid = new String[fishingGridRow][fishingGridCol]; // Ukuran grid 2x3
        this.gold = 20; // Inisialisasi gold
    }


    // Display Menu
    public String displayMenu() {
        System.out.println("\n=== Menu Fishing Game ===");
        System.out.println("Gold: " + gold);
        System.out.println("1. Fishing");
        System.out.println("2. Shop");
        System.out.println("3. Exit");
        System.out.println("=========================");
        System.out.print("Pilihan: ");
        String choice = scanner.nextLine();
        return choice;
    }

    // Method to get a random fish
    private Fish getRandomFish() {
        List<Fish> fishList = new ArrayList<>();
        fishList.add(new CommonCarp());
        fishList.add(new CatFish());
        fishList.add(new Tuna());
        fishList.add(new Swordfish());
        fishList.add(new RedSnapper());

        Random random = new Random();
        return fishList.get(random.nextInt(fishList.size()));
    }

    // Mengisi grid dengan ikan di posisi acak
    void populateGrid() {
        Random random = new Random();
        int fishRow = random.nextInt(fishingGridRow); // Baris acak
        int fishCol = random.nextInt(fishingGridCol);

        fishInGrid = getRandomFish();

        for (String[] row : fishingGrid) {
            for (int j = 0; j < row.length; j++) {
                row[j] = "[ ]"; // Semua kotak kosong
            }
        }
        fishingGrid[fishRow][fishCol] = "[F]"; // Tempatkan ikan dengan logo F
    }

    // Menampilkan isi grid
    public void displayGrid() {
        System.out.print("[_]");
        for (int i = 0; i < fishingGridCol; i++) {
            System.out.print("[" + (char) ('A' + i) + "]");
        }
        System.out.println();
        for (int i = 0; i < fishingGrid.length; i++) {
            System.out.print("[" + (i + 1) + "]");
            for (int j = 0; j < fishingGrid[i].length; j++) {
                System.out.print("[ ]");
            }
            System.out.println();
        }
    }

    public String[][] getGrid() {
        return fishingGrid;
    }

    public int[] chooseGridValidation(String chooseGrid) {
        if (chooseGrid.length() == 2) {
            char firstChar = chooseGrid.charAt(0);
            char secondChar = chooseGrid.charAt(1);
            int row = -1;
            char col = ' ';

            if (Character.isDigit(firstChar) && Character.isLetter(secondChar)) {
                row = Character.getNumericValue(firstChar);
                col = secondChar;
            } else if (Character.isLetter(firstChar) && Character.isDigit(secondChar)) {
                row = Character.getNumericValue(secondChar);
                col = firstChar;
            }

            col = Character.toUpperCase(col);
            int colNum = col - 'A';
            row = row - 1;

            if (row >= 0 && row < fishingGridRow && colNum >= 0 && colNum < fishingGridCol) {
                return new int[]{row, colNum};
            } else {
                System.out.println("Invalid input. Please enter a valid grid location.");
                return null;
            }

        } else {
            System.out.println("Invalid input. Please enter a valid grid location.");
            return null;
        }
    }

    public void fishing() {
        populateGrid();
        displayGrid();
        int attempt = 3;
        boolean fishCaught = false;

        while (attempt > 0 && !fishCaught) {
            System.out.print("Where to throw your hook : ");
            String chooseGrid = scanner.nextLine();
            int[] grid = chooseGridValidation(chooseGrid);
            if (grid == null) {
                System.out.println("Invalid input. Please enter a valid grid location.");
                continue;
            }
            int row = grid[0];
            int col = grid[1];

            if (fishingGrid[row][col].equals("[F]")) {
                System.out.println("You got a " + fishInGrid.getName() + "!" + " Grade: " + fishInGrid.getGrade());
                gold += fishInGrid.getGold();
                System.out.println("You Got Gold: " + gold);
                fishCaught = true;
            } else {
                attempt--;
                System.out.println("You got nothing!, Retry attempt " + attempt);
                if (attempt == 0) {
                    gold -= 5;
                    System.out.println("Gold: " + gold);
                }
            }
        }
    }

    public static void main(String[] args) {
        FishingGame game = new FishingGame();
        while (true) {
            String choice = game.displayMenu();
            if (Objects.equals(choice, "1")) {
                game.fishing();
            } else if (Objects.equals(choice, "2")) {
                System.out.println("Shop is not implemented yet.");
            } else if (Objects.equals(choice, "3")) {
                break;
            } else {
                System.out.println("Invalid choice. Please select again.");
            }
        }
        game.scanner.close();
    }

}
