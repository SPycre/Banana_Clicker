package com.banana_clicker.controllers;

import com.banana_clicker.manager.GameManager;
import com.banana_clicker.models.Registry;
import com.banana_clicker.models.Upgrades;
import com.banana_clicker.models.upgrades.Upgrade;
import com.banana_clicker.models.utils.BananaPerSecond;
import com.banana_clicker.models.utils.EventSource;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class GameplayController {

    public final EventSource updateUpgrades = new EventSource();
    public final EventSource updateMonkeys = new EventSource();

    private final GameManager manager;
    private final BananaPerSecond bananaPerSecond;
    private boolean stopThread;

    private final StringProperty bananaText = new SimpleStringProperty();
    private final Stage stage;

    public GameplayController(Stage stage, GameManager manager) {
        this.stage = stage;
        this.manager = manager;
        this.bananaPerSecond = new BananaPerSecond(manager);
        new Thread(new Runnable() {
            @Override
            public void run() {
                stopThread = false;
                while (!stopThread) {
                    try {
                        Thread.sleep(1000);
                        long totalGain = bananaPerSecond.CalculateTotalGain();
                        Platform.runLater(() -> {
                            addBananas(totalGain);
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        this.stage.setOnCloseRequest(a -> stopThread = true);
    }


    public StringProperty bananaProperty() {
        return bananaText;
    }
    public void BananaClick() {
        addBananas(1);
    }

    private void addBananas(long amount) {
        manager.addBananas(amount);
        bananaText.set("Bananas : " + Double.toString(manager.getBananas()));
    }

    public long getMonkeyPrice(String name) {
        return manager.getMonkeys().get(name).getPrice();
    }

    public long getUpgradePrice(String name) {
        return Registry.getAllUpgrades().get(name).getPrice();
    }

    public int getMonkeyCount(String name) {
        return manager.getMonkeys().get(name).getCount();
    }

    public void BuyUpgrade(String name) {
        long price = getUpgradePrice(name);
        if (price <= manager.getBananas()) {
            addBananas(-price);
            manager.addUpgrade(name);
        }
        updateUpgrades.fireEvent();
    }

    public void BuyMonkey(String name) {
        long price = getMonkeyPrice(name);
        if (price <= manager.getBananas()) {
            addBananas(-price);
            manager.addMonkey(name, 1);
        }
        updateUpgrades.fireEvent();
        updateMonkeys.fireEvent();
    }

    public List<String> getAvailableMonkeys() {
        return Registry.getAvailableMonkeys(manager);
    }

    public List<Upgrade> getAvailableUpgrades() {
        return Registry.getAvailableUpgrades(manager);
    }

}
