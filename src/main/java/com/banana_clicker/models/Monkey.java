package com.banana_clicker.models;

import com.banana_clicker.models.utils.RequiredCondition;

import static java.lang.Math.pow;

public class Monkey {
    private final String name;
    private int count;
    private final long bananaPerSecond;
    private final RequiredCondition requiredCondition;
    private final double basePrice;

    public Monkey(String name, long bananaPerSecond,long basePrice, RequiredCondition requiredCondition) {
        this.name = name;
        this.count = 0;
        this.bananaPerSecond = bananaPerSecond;
        this.basePrice = basePrice;
        this.requiredCondition = requiredCondition;
    }

    public RequiredCondition getRequiredCondition() {return requiredCondition;}
    public int getCount() {
        return count;
    }
    public String getName() {
        return name;
    }
    public long getPrice() {
        return  Math.round(basePrice * pow(1.15, count));
    }
    public  long getBananaPerSecond() {
        return count*bananaPerSecond;
    }

    public void add(int amount) {
        count += amount;
    }






}
