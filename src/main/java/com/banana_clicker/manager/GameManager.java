package com.banana_clicker.manager;

import com.banana_clicker.dao.GameDataDao;
import com.banana_clicker.models.Monkey;
import com.banana_clicker.models.Registry;
import com.banana_clicker.models.Upgrades;
import com.banana_clicker.models.upgrades.Upgrade;

import java.util.*;

import static com.banana_clicker.models.Registry.getAllMonkeys;

public class GameManager {

    private long bananas;
    private  Map<String, Monkey> monkeys;
    private Upgrades upgrades;

    public GameManager() {
        setDefaultState();
    }

    //region setters / getters
    public double getBananas() {
        return bananas;
    }

    public void addBananas(long amount) {
        this.bananas += amount;
    }

    public Map<String, Monkey> getMonkeys() {
        return monkeys;
    }

    public void addMonkey(String name, int amount) {
        monkeys.get(name).add(amount);
    }

    public Upgrades getUpgrades() {
        return upgrades;
    }

    public void addUpgrade(String name) {
        this.upgrades.AddUpgrade(Registry.getAllUpgrades().get(name));
    }
    //endregion

  //region save / load data

    public void setDefaultState() {
        bananas = 0;
        monkeys = getAllMonkeys();
        upgrades = new Upgrades();
    }

    public void loadSavedState(String savename) {
        setDefaultState();
        Map<String, Object> loadedData= GameDataDao.loadGameData(savename);

        // Load bananas
        bananas = (long) loadedData.get("bananas");

    }

    public void saveGame(String savename) {
        Map<String, Object> gameData = new HashMap<>();

        gameData.put("bananas", bananas);

        GameDataDao.saveGameData(savename, gameData);
    }


//endregion


}
