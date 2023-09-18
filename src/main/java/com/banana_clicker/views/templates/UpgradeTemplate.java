package com.banana_clicker.views.templates;

import com.banana_clicker.controllers.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class UpgradeTemplate {

    @FXML private Button upgradeButton;
    @FXML private Label upgradeName;
    @FXML private Label upgradePrice;

    private GameplayController controller;

    public void setName(String name) {
        upgradeName.setText(name);
    }
    public void setPrice(long price) {
        upgradePrice.setText(Double.toString(price) + " Bananas");
    }

    public void setController(GameplayController controller) {
        this.controller = controller;
    }

    @FXML private void upgradeClick() {
        controller.BuyUpgrade(upgradeName.getText());
    }

}
