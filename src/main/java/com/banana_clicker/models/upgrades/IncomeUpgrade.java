package com.banana_clicker.models.upgrades;

import com.banana_clicker.models.utils.RequiredCondition;

public class IncomeUpgrade extends Upgrade{

    private double multiplier;

    public IncomeUpgrade(String name, long price, RequiredCondition requiredCondition, double multiplier) {
        super(name, price, requiredCondition);
        this.multiplier = multiplier;
    }

}
