package br.com.hospitalmanagementsystem.hospitalmanagementsystem.models;

public enum UserRole {
    ADMIN("admin"),
    ATENDENTE("atendente"),
    MEDICO("medico"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
