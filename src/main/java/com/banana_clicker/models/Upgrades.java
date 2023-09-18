package com.banana_clicker.models;

import com.banana_clicker.models.upgrades.IncomeUpgrade;
import com.banana_clicker.models.upgrades.MonkeyUpgrade;
import com.banana_clicker.models.upgrades.Upgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Upgrades {

    private Map<String,Upgrade> upgrades;
    private List<MonkeyUpgrade> monkeyUpgrades;

    private List<IncomeUpgrade> incomeUpgrades;

    public Upgrades() {
        upgrades = new HashMap<>();
        monkeyUpgrades = new ArrayList<>();
        incomeUpgrades = new ArrayList<>();
    }

    public void AddUpgrade(Upgrade upgrade) {

        upgrades.put(upgrade.getName(),upgrade);

        if (upgrade.getClass().equals(MonkeyUpgrade.class)) {
            monkeyUpgrades.add((MonkeyUpgrade) upgrade);
        } else if (upgrade.getClass().equals(IncomeUpgrade.class)) {
            incomeUpgrades.add((IncomeUpgrade) upgrade);
        }

    }


    public Map<String,Upgrade> getUpgrades() { return upgrades; }
    public List<MonkeyUpgrade> getMonkeyUpgrades() {
        return monkeyUpgrades;
    }

}
