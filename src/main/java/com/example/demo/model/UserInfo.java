package com.example.demo.model;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String name;
    private String email;
    private String bairthday;
    private String occupation;

    // Getters and Setters
}
