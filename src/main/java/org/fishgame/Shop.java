package org.fishgame;

import java.util.ArrayList;
import java.util.List;

import fishingrod.BasicFishingRod;
import fishingrod.DiamondFishingRod;
import fishingrod.FishingRod;
import fishingrod.GoldFishingRod;
import fishingrod.PlatinumFishingRod;

public class Shop {

    private List<FishingRod> fishingRodList;

    public Shop() {
        this.fishingRodList = new ArrayList<>();
        fishingRodList.add(new BasicFishingRod());
        fishingRodList.add(new GoldFishingRod());
        fishingRodList.add(new PlatinumFishingRod());
        fishingRodList.add(new DiamondFishingRod());
    }

    // Menampilkan daftar alat pancing
    public void displayFishingRods() {
        System.out.println("\nWelcome to the Fishing Rod Shop!");
        for (int i = 0; i < fishingRodList.size(); i++) {
            FishingRod rod = fishingRodList.get(i);
            System.out.println((i + 1) + ". " + rod.getName() + " - " + rod.getPrice());
        }
    }

    // Membeli alat pancing
    public boolean purchaseFishingRod(int index, int playerGold) {
        if (index < 1 || index > fishingRodList.size()) {
            System.out.println("Invalid choice. Please select a valid fishing rod.");
            return false;
        }

        FishingRod selectedRod = fishingRodList.get(index - 1);
        if (playerGold >= selectedRod.getPrice()) {
            System.out.println("You purchased: " + selectedRod.getName());
            return true;
        } else {
            System.out.println("Not enough Gold to buy " + selectedRod.getName());
            return false;
        }
    }

    public List<FishingRod> getFishingRodList() {
        return fishingRodList;
    }
}
