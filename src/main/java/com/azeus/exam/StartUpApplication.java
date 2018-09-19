package com.azeus.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartUpApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(StartUpApplication.class, args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
