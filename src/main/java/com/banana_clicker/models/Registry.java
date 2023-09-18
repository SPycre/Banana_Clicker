package com.banana_clicker.models;

import com.banana_clicker.manager.GameManager;
import com.banana_clicker.models.upgrades.MonkeyUpgrade;
import com.banana_clicker.models.upgrades.Upgrade;
import com.banana_clicker.models.utils.RequiredCondition;

import java.util.*;

public class Registry {

    public static Map<String,Monkey> getAllMonkeys() {
        Map<String, Monkey> Monkeys = new HashMap<>();

        // Baboonkid
        RequiredCondition baboonkid_condition = new RequiredCondition();
        Monkey baboonkid = new Monkey("Baboon Kid",1,100, baboonkid_condition);
        Monkeys.put(baboonkid.getName(),baboonkid);

        return Monkeys;
    }

    public static Map<String,Upgrade> getAllUpgrades() {
        Map<String, Upgrade> Upgrades = new HashMap<>();

        RequiredCondition bu1_condition = new RequiredCondition();
        bu1_condition.addRequiredMonkey("Baboon Kid",1);
        MonkeyUpgrade baboon_upgrade1 = new MonkeyUpgrade("BaboonKid 1", 1000, bu1_condition, "Baboon Kid",2);
        Upgrades.put(baboon_upgrade1.getName(), baboon_upgrade1);

        RequiredCondition bu2_condition = new RequiredCondition();
        bu2_condition.addRequiredMonkey("Baboon Kid",5);
        MonkeyUpgrade baboon_upgrade2 = new MonkeyUpgrade("BaboonKid 2", 5000, bu2_condition, "Baboon Kid",2);
        Upgrades.put(baboon_upgrade2.getName(), baboon_upgrade2);

        RequiredCondition bu3_condition = new RequiredCondition();
        bu3_condition.addRequiredMonkey("Baboon Kid",25);
        MonkeyUpgrade baboon_upgrade3 = new MonkeyUpgrade("BaboonKid 3", 50000, bu3_condition, "Baboon Kid",2);
        Upgrades.put(baboon_upgrade3.getName(), baboon_upgrade3);

        RequiredCondition bu4_condition = new RequiredCondition();
        bu4_condition.addRequiredMonkey("Baboon Kid",50);
        MonkeyUpgrade baboon_upgrade4 = new MonkeyUpgrade("BaboonKid 4", 5000000, bu4_condition, "Baboon Kid",2);
        Upgrades.put(baboon_upgrade4.getName(), baboon_upgrade4);

        RequiredCondition bu5_condition = new RequiredCondition();
        bu5_condition.addRequiredMonkey("Baboon Kid",100);
        MonkeyUpgrade baboon_upgrade5 = new MonkeyUpgrade("BaboonKid 5", 500000000, bu5_condition, "Baboon Kid",2);
        Upgrades.put(baboon_upgrade5.getName(), baboon_upgrade5);

        return Upgrades;
    }


    public static List<String> getAvailableMonkeys(GameManager gameManager) {
        List<String> availableMonkey = new ArrayList<>();
        for (Monkey baseMonkey : getAllMonkeys().values()) {
            if (baseMonkey.getRequiredCondition().hasRequired(gameManager)) {
                availableMonkey.add(baseMonkey.getName());
            }
        }
        return availableMonkey;
    }

    public static List<Upgrade> getAvailableUpgrades(GameManager gameManager) {
        List<Upgrade> availableUpgrade = new ArrayList<>();
        Set<String> ownedUpgrades = gameManager.getUpgrades().getUpgrades().keySet();
        for (Upgrade baseUpgrade : getAllUpgrades().values()) {
            boolean unlocked = true;
            if (ownedUpgrades.contains(baseUpgrade.getName())) {
                unlocked = false;
            }
            if (!baseUpgrade.getRequiredCondition().hasRequired(gameManager)) {
                unlocked = false;
            }
            if (unlocked) { availableUpgrade.add(baseUpgrade); }
        }
        return availableUpgrade;
    }

}
