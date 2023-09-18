package com.banana_clicker.models.upgrades;

import com.banana_clicker.models.utils.RequiredCondition;

public abstract class Upgrade {

    private final String name;
    private final long price;
    private final RequiredCondition requiredCondition;

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public RequiredCondition getRequiredCondition() {
        return requiredCondition;
    }

    public  Upgrade(String name, long price, RequiredCondition requiredCondition) {
        this.name = name;
        this.price = price;
        this.requiredCondition = requiredCondition;
    }

}
