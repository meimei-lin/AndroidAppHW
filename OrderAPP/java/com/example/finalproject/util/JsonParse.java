package com.example.finalproject.util;

import com.example.finalproject.bean.Food;
import com.example.finalproject.bean.Menu;
import com.google.gson.Gson;

public class JsonParse {
    public static Menu parseFoodJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Menu.class);
    }
}
