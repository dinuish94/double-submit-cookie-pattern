package com.sliit.ssd.csrfapp;

/**
 * Created by dinukshakandasamanage on 9/5/18.
 */

import com.sliit.ssd.csrfapp.models.UserCredentialsStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        UserCredentialsStore.getUserCredentialsStore().addInitialData();
    }

}