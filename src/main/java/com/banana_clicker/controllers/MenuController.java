package com.banana_clicker.controllers;

import com.banana_clicker.manager.GameManager;
import com.banana_clicker.views.GameplayView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private Stage stage;

    public MenuController(Stage stage) {
        this.stage = stage;
    }

    public void StartNewGame() {
        try {
            GameManager gameManager = new GameManager();
            gameManager.setDefaultState();

            GameplayController gameplayController = new GameplayController(stage, gameManager);

            GameplayView gameplayView = new GameplayView(gameplayController);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/banana_clicker/ui/gameplay.fxml"));
            loader.setController(gameplayView);

            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
