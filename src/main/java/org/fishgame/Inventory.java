package org.fishgame;

import java.util.ArrayList;
import java.util.List;

import fishingrod.BasicFishingRod;
import fishingrod.FishingRod;

public class Inventory {

    private final List<FishingRod> fishingRods = new ArrayList<>();
    private FishingRod equippedFishingRod;

    public Inventory() {
        // Tambahkan BasicFishingRod sebagai fishing rod awal
        FishingRod defaultRod = new BasicFishingRod();
        fishingRods.add(defaultRod);
        equippedFishingRod = defaultRod; // Atur BasicFishingRod sebagai alat pancing default
    }

    public void addFishingRod(FishingRod rod) {
        fishingRods.add(rod);
        System.out.println(rod.getName() + " added to inventory.");
    }

    public void equipFishingRod(int index) {
        if (index > 0 && index <= fishingRods.size()) {
            equippedFishingRod = fishingRods.get(index - 1);
            System.out.println("Equipped: " + equippedFishingRod.getName());
        } else {
            System.out.println("Invalid index. Please select a valid fishing rod.");
        }
    }

    public int equipFishingRodChance() {
        return equippedFishingRod.getChance();
    }

    public FishingRod getEquippedFishingRod() {
        return equippedFishingRod;
    }

    public void displayInventory() {
        System.out.println("\n=== Inventory ===");
        for (int i = 0; i < fishingRods.size(); i++) {
            System.out.println((i + 1) + ". " + fishingRods.get(i).getName());
        }
        System.out.println("=================");
    }
}
