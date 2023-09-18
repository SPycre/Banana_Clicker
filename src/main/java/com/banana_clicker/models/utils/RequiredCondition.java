package com.banana_clicker.models.utils;

import com.banana_clicker.manager.GameManager;

import java.util.HashMap;
import java.util.Map;

public class RequiredCondition {

    private Map<String, Integer> requiredMonkeys = new HashMap<>();

    public void addRequiredMonkey(String name, Integer count) {
        requiredMonkeys.put(name, count);
    }

    public boolean hasRequired(GameManager gameManager) {
        boolean hasReq = true;
        for (String name : requiredMonkeys.keySet()) {
            if (gameManager.getMonkeys().get(name).getCount() < requiredMonkeys.get(name)) {
                hasReq = false;
            }
        }
        return hasReq;
    }

}
