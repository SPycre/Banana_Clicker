package com.banana_clicker.views.templates;

import com.banana_clicker.controllers.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MonkeyTemplate {

    @FXML private Button monkeyButton;
    @FXML private Label monkeyName;
    @FXML private Label monkeyPrice;
    @FXML private Label monkeyCount;

    private GameplayController controller;

    public void setName(String name) {
        monkeyName.setText(name);
    }

    public void setPrice(long price) {
        monkeyPrice.setText(Double.toString(price) + " Bananas");
    }

    public void setCount(int count) {
        monkeyCount.setText(Integer.toString(count));
    }

    public void setController(GameplayController controller) {
        this.controller = controller;
    }

    @FXML private void monkeyClick() {
        controller.BuyMonkey(monkeyName.getText());
    }

}
