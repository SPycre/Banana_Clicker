package com.banana_clicker.models.utils;

import com.banana_clicker.manager.GameManager;
import com.banana_clicker.models.Monkey;
import com.banana_clicker.models.upgrades.MonkeyUpgrade;

import java.util.HashMap;
import java.util.Map;

public class BananaPerSecond {

    private GameManager manager;

    public BananaPerSecond(GameManager manager) {
        this.manager = manager;
    }

    public long CalculateTotalGain() {

        Map<String, Long> totalMonkeysGain = new HashMap<>();
        for (Monkey monkey : manager.getMonkeys().values()) {
            totalMonkeysGain.put(monkey.getName(),monkey.getBananaPerSecond());
        }

        for (MonkeyUpgrade monkeyUpgrade : manager.getUpgrades().getMonkeyUpgrades()) {
            long baseValue = totalMonkeysGain.get(monkeyUpgrade.getMonkeyName());
            totalMonkeysGain.put(monkeyUpgrade.getMonkeyName(), Math.round(baseValue * monkeyUpgrade.getMultiplier()));
        }

        long totalGain = 0;
        for (long monkeyGain : totalMonkeysGain.values()) {
            totalGain += monkeyGain;
        }

        return totalGain;

    }

}
