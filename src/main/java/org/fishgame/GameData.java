package org.fishgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fish.Fish;
import fishingrod.BasicFishingRod;
import fishingrod.DiamondFishingRod;
import fishingrod.FishingRod;
import fishingrod.GoldFishingRod;
import fishingrod.PlatinumFishingRod;

public class GameData {
    private int gold;
    private Inventory inventory;

    private static final String SAVE_FILE_PATH = "gameData.txt";
    private boolean isLoading = false;

    public GameData() {
        this.inventory = new Inventory();
        inventory.setGameData(this); // Set GameData ke Inventory
        loadGameData();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
        saveGameData();
    }

    public void addGold(int amount) {
        this.gold += amount;
        saveGameData();
    }

    public void subtractGold(int amount) {
        this.gold = Math.max(0, this.gold - amount);
        saveGameData();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void saveGameData() {
        if (isLoading) return;
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))) {
            writer.write("gold=" + gold);
            writer.newLine();
    
            for (FishingRod rod : inventory.getFishingRods()) {
                writer.write("rod=" + rod.getName() + "," + rod.getChance() + "," + rod.getGrade());
                writer.newLine();
            }
    

            FishingRod equippedRod = inventory.getEquippedFishingRod();
            if (equippedRod != null) {
                writer.write("equipped=" + equippedRod.getName() + "," + equippedRod.getChance() + "," + equippedRod.getGrade());
                writer.newLine();
            }
    
            System.out.println("Game data saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save game data: " + e.getMessage());
        }
    }

    private void loadGameData() {
        File file = new File(SAVE_FILE_PATH);
        if (!file.exists()) {
            System.out.println("No save file found. Starting with default values.");
            return;
        }
    
        isLoading = true; 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<FishingRod> loadedRods = new ArrayList<>();
            FishingRod equippedRod = null;
    
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("gold=")) {
                    this.gold = Integer.parseInt(line.substring(5));
    
                } else if (line.startsWith("rod=")) {
                    String[] parts = line.substring(4).split(",");
                    if (parts.length == 3) { 
                        String name = parts[0];
                        int chance = Integer.parseInt(parts[1]);
                        FishingRod.FishingRodGrade grade = FishingRod.FishingRodGrade.valueOf(parts[2]);
    
                        FishingRod rod = createRodByAttributes(name, chance, grade);
                        if (rod != null) {
                            loadedRods.add(rod);
                        }
                    }
    
                } else if (line.startsWith("equipped=")) {
                    String[] parts = line.substring(9).split(",");
                    if (parts.length == 3) { 
                        String name = parts[0];
                        int chance = Integer.parseInt(parts[1]);
                        FishingRod.FishingRodGrade grade = FishingRod.FishingRodGrade.valueOf(parts[2]);
    
                        equippedRod = createRodByAttributes(name, chance, grade);
                    }
                }
            }
    
            for (FishingRod rod : loadedRods) {
                if (!inventory.getFishingRods().contains(rod)) {
                    inventory.addFishingRod(rod);
                }
            }
    
        
            if (equippedRod != null) {
                inventory.equipFishingRod(loadedRods.indexOf(equippedRod) + 1);
            }
    
            System.out.println("Game data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load game data: " + e.getMessage());
        } finally {
            isLoading = false;
        }
    }
    

    private FishingRod createRodByAttributes(String name, int chance, FishingRod.FishingRodGrade grade) {
        switch (name.toLowerCase()) {
            case "basic fishing rod":
                return new BasicFishingRod();
            case "gold fishing rod":
                return new GoldFishingRod();
            case "platinum fishing rod":
                return new PlatinumFishingRod ();
            case "diamond fishing rod":
                return new DiamondFishingRod();
            default:
                System.err.println("Unknown FishingRod: " + name);
                return null;
        }
    }

    public void addGoldFromFish(Fish fish) {
        if (fish != null) {
            int fishGold = fish.getGold();
            this.gold += fishGold;
            System.out.println("You earned " + fishGold + " gold from catching a " + fish.getName() + "!");
            saveGameData();
        } else {
            System.out.println("No fish caught. No gold added.");
        }
    }
}
