package com.sisko.exam.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCurrentPlan() { return currentPlan; }
    public void setCurrentPlan(String currentPlan) { this.currentPlan = currentPlan; }
    public String getBilling() { return billing; }
    public void setBilling(String billing) { this.billing = billing; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
