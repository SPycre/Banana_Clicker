package com.banana_clicker.models.utils;

import com.banana_clicker.models.interfaces.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventSource {

    private List<Listener> listeners = new ArrayList<>();

    public void addListener (Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void fireEvent() {
        for (Listener listener : listeners) {
            listener.onEvent();
        }
    }

}
