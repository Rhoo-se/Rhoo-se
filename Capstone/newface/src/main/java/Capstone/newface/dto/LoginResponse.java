package Capstone.newface.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class LoginResponse {
    private boolean success;
    private String message;
    private String mail;
    private String token;

    public LoginResponse(boolean success, String message, String mail, String token) {
        this.success = success;
        this.message = message;
        this.mail = mail;
        this.token = token;
    }

    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.mail = null;
        this.token = null;
    }


}
