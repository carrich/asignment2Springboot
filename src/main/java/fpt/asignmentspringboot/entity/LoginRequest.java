package fpt.asignmentspringboot.entity;

import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "not Null")
    private String email;
    @NotNull(message = "not Null")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
