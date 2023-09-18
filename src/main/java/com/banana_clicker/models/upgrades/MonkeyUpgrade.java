package com.banana_clicker.models.upgrades;

import com.banana_clicker.models.utils.RequiredCondition;

public class MonkeyUpgrade extends Upgrade {

    private final double multiplier;
    private final String monkeyName;

    public String getMonkeyName() {
        return monkeyName;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public MonkeyUpgrade(String name, int cost, RequiredCondition requiredCondition, String monkeyName, double multiplier) {
        super(name, cost, requiredCondition);
        this.monkeyName = monkeyName;
        this.multiplier = multiplier;
    }

}
