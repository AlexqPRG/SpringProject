package com.API.shopAPI.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {

    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;

    public SignUpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public SignUpRequest(){}

    public @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов") @NotBlank(message = "Имя пользователя не может быть пустыми") String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов") @NotBlank(message = "Имя пользователя не может быть пустыми") String username) {
        this.username = username;
    }

    public @Size(max = 255, message = "Длина пароля должна быть не более 255 символов") String getPassword() {
        return password;
    }

    public void setPassword(@Size(max = 255, message = "Длина пароля должна быть не более 255 символов") String password) {
        this.password = password;
    }
}
