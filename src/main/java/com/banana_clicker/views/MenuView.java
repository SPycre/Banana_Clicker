package com.banana_clicker.views;

import com.banana_clicker.controllers.MenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuView {

    @FXML private Button startButton;

    private MenuController controller;
    private Stage stage;

    public MenuView(MenuController controller) {
        this.controller = controller;
    }

    public void initialize() {
        startButton.setOnAction(a -> controller.StartNewGame());
    }

}
