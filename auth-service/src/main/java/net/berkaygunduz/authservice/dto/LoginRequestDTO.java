package net.berkaygunduz.authservice.dto;

import jakarta.validation.constraints.*;

public class LoginRequestDTO {

    @NotBlank(message = "Email is required.")
    @Email(message = "email should be a valid email address.")
    private String email;

    @NotBlank(message = "Password required.")
    @Size(min = 8,message = "Password must be at least 8 char.")
    private String password;

    public @NotBlank(message = "Password required.") @Size(min = 8, message = "Password must be at least 8 char.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password required.") @Size(min = 8, message = "Password must be at least 8 char.") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Email is required.") @Email(message = "email should be a valid email address.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required.") @Email(message = "email should be a valid email address.") String email) {
        this.email = email;
    }
}
