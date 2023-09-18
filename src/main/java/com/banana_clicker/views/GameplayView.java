package com.banana_clicker.views;

import com.banana_clicker.controllers.GameplayController;
import com.banana_clicker.models.Monkey;
import com.banana_clicker.models.Registry;
import com.banana_clicker.models.Upgrades;
import com.banana_clicker.models.upgrades.Upgrade;
import com.banana_clicker.views.templates.MonkeyTemplate;
import com.banana_clicker.views.templates.UpgradeTemplate;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.Map;

public class GameplayView {

    @FXML private Button bananaButton;
    @FXML private Label bananaCounter;

    @FXML private ScrollPane upgradesList;
    @FXML private ScrollPane monkeysList;

    private GameplayController controller;
    private Stage stage;

    public GameplayView(GameplayController controller) {
        this.controller = controller;
    }

    public void initialize() {
        controller.updateUpgrades.addListener(this::fillUpgrades);
        controller.updateMonkeys.addListener(this::fillMonkeys);

        bananaCounter.textProperty().bind(controller.bananaProperty());
        bananaButton.setOnAction(a -> bananaClick());

        fillUpgrades();
        fillMonkeys();
    }

    private void bananaClick() {

        controller.BananaClick();

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.01), bananaButton);
        scaleTransition.setToX(.9);
        scaleTransition.setToY(.9);

        scaleTransition.setOnFinished(e -> {
            ScaleTransition reverseTransition = new ScaleTransition(Duration.seconds(0.01), bananaButton);
            reverseTransition.setToX(1);
            reverseTransition.setToY(1);
            reverseTransition.play();
        });

        scaleTransition.play();
    }

    @FXML private void fillUpgrades() {
        List<Upgrade> unlockedUpgrades = controller.getAvailableUpgrades();

        VBox list = new VBox();
        for (Upgrade upgrade : unlockedUpgrades) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/banana_clicker/drawable/upgradeTemplate.fxml"));
                Parent root = loader.load();

                UpgradeTemplate upgradeTemplate = loader.getController();
                upgradeTemplate.setController(controller);
                upgradeTemplate.setName(upgrade.getName());
                upgradeTemplate.setPrice(upgrade.getPrice());
                list.getChildren().add(root);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        upgradesList.setContent(list);
    }

    @FXML private void fillMonkeys() {
        Map<String, Monkey> monkeys = Registry.getAllMonkeys();
        List<String> unlockedMonkeys = controller.getAvailableMonkeys();

        VBox list = new VBox();
        for (String name : monkeys.keySet()) {
            try {
                boolean unlocked = unlockedMonkeys.contains(name);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/banana_clicker/drawable/monkeyTemplate.fxml"));
                Parent root = loader.load();

                MonkeyTemplate monkeyTemplate = loader.getController();
                monkeyTemplate.setController(controller);
                monkeyTemplate.setName(unlocked ? name : "???");
                monkeyTemplate.setPrice(controller.getMonkeyPrice(name));
                monkeyTemplate.setCount(controller.getMonkeyCount(name));
                list.getChildren().add(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        monkeysList.setContent(list);
    }

}
