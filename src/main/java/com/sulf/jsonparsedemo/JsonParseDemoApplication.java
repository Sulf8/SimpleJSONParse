package com.sulf.jsonparsedemo;

import com.sulf.jsonparsedemo.model.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonParseDemoApplication {

    public static void main(String[] args) {
        //JsonSimpleParser parser = new JsonSimpleParser();//for parse using SimpleParser lib, change "people_list" to "people" in test.json
        GsonParser parser = new GsonParser();//for parse using Gson lib
        Root root = parser.parse();
        System.out.println("Root: "+ root.toString());
    }

}
