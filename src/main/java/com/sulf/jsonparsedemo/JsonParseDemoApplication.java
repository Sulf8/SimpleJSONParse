package com.sulf.jsonparsedemo;

import com.sulf.jsonparsedemo.model.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonParseDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JsonParseDemoApplication.class, args);
        JsonSimpleParser parser = new JsonSimpleParser();
        Root root = parser.parse();
        System.out.println("Root: "+ root.toString());
    }

}
