package Capstone.newface.controller;

import Capstone.newface.dto.LoginRequest;
import Capstone.newface.dto.LoginResponse;
import Capstone.newface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("### UserController.login method called ###"); // <-- 이 로그 추가
        System.out.println("### Received LoginRequest: mail=" + loginRequest.getMail() + ", pwd=" + loginRequest.getPwd() + " ###"); // <-- DTO 값 확인 로그 추가

        LoginResponse response = userService.authenticateUser(loginRequest);
        System.out.println("DB에서 찾은 메일 값 : " + response.getMail());
        System.out.println("DB에서 찾은 비번 값 : " + response.getMail());
        if(response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else{
            return ResponseEntity.status(401).body(response);
        }
    }
}
