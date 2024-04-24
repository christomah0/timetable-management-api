package com.ihm.timetablemanagement.utils;


import lombok.Getter;

import java.util.HashMap;

@Getter
public class ServerMessage {
    private final HashMap<String, String> server;

    public ServerMessage() {
        this.server = new HashMap<>();
    }

    public void setMessage(String key, String value) {
        this.server.put(key, value);
    }

}
