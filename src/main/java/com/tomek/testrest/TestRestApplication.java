package com.tomek.testrest;

import com.tomek.testrest.Repoistory.PersonRepoistory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@SpringBootApplication
public class TestRestApplication {

    public static void main(String[] args){
        SpringApplication.run(TestRestApplication.class, args);

    }

}
