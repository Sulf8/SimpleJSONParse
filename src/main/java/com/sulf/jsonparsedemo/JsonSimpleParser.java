package com.sulf.jsonparsedemo;

import com.sulf.jsonparsedemo.model.People;
import com.sulf.jsonparsedemo.model.Root;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JsonSimpleParser {
    /*private static  final String TAG_ROOT_NAME= "name";
    private static final String TAG_NAME= "name";
    private static final String TAG_PEOPLE= "people";
    private static final String TAG_AGE= "age";*/

    Root root = new Root();

    public Root parse() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("test.json")
             //FileReader propReader= new FileReader(new File("src/main/resources/application.properties").getAbsolutePath())
             //InputStream is = JsonSimpleParser.class.getResourceAsStream("/application.properties")
             //InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        ) {
          /*Properties properties = new Properties();
          properties.load(is);*/ //NullPointerException!!!!!!!!!!!!!
          JSONObject rootJsonObject= (JSONObject)jsonParser.parse(reader);

          String name = (String) rootJsonObject.get("name");
          JSONArray peopleJsonArray = (JSONArray) rootJsonObject.get("people");

            List<People> peopleList = new ArrayList<>();
            for (Object peopleObject: peopleJsonArray
                 ) {
                JSONObject peopleJsonObject = (JSONObject) peopleObject;

                String peopleName = (String) peopleJsonObject.get("name");
                long age = (Long) peopleJsonObject.get("age");
                peopleList.add(new People(peopleName, (int)age));
            }

          root.setName(name);
          root.setPeople(peopleList);
          return root;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
