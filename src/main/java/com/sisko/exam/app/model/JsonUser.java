package com.sisko.exam.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonUser {
    private Long id;
    @JsonProperty("full_name")
    private String fullName;
    private String role;
    private String username;
    private String email;
    @JsonProperty("current_plan")
    private String currentPlan;
    private String billing;
    private int status;
    private String avatar;
    private String password;
}
