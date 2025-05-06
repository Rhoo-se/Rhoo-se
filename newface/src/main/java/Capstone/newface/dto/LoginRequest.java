package Capstone.newface.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class LoginRequest {
    private String mail;
    private String pwd;
}

