package com.ihm.timetablemanagement.utils;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class ServerResponses {
    private final List<HashMap<String, String>> server;

    public ServerResponses() {
        this.server = new ArrayList<>();
    }

    public void setResponse(String key, String value) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(key, value);
        this.server.add(hashMap);
    }
}
