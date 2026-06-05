package com.workspacesharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WorkspaceSharingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkspaceSharingApplication.class, args);
    }

}
