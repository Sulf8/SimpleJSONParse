package com.sulf.jsonparsedemo;

import com.google.gson.Gson;
import com.sulf.jsonparsedemo.model.Root;

import java.io.FileReader;

public class GsonParser {
    Root root = new Root();

    public Root parse(){
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("test.json")
        ) {
           root = gson.fromJson(reader, Root.class);
           return root;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
