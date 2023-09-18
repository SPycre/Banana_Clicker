package com.banana_clicker.dao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameDataDao {

    private static  final String SAVE_FILE_PATH = "savegame.ser";

    public static void saveGameData(String save_name, Map<String, Object> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_PATH))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> loadGameData(String save_name) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE_PATH))) {
            Map<String, Object> data = (Map<String, Object>) inputStream.readObject();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("No saved game data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

}
