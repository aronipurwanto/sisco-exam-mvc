package com.sisko.exam.app.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonUser {
    private Long id;
    private String username;
    private String password;
    private String role;
}