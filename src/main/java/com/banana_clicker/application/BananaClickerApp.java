package com.banana_clicker.application;

import com.banana_clicker.controllers.MenuController;
import com.banana_clicker.views.MenuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BananaClickerApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            MenuController menuController = new MenuController(primaryStage);

            MenuView menuView = new MenuView(menuController);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/banana_clicker/ui/menu.fxml"));
            loader.setController(menuView);

            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setFullScreen(true);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
