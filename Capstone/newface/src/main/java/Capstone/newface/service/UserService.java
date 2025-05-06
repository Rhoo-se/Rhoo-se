package Capstone.newface.service;

import Capstone.newface.dto.LoginRequest;
import Capstone.newface.dto.LoginResponse;
import Capstone.newface.domain.User;
import Capstone.newface.entity.UserEntity;
import Capstone.newface.repository.UserRepository;
import Capstone.newface.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Optional<UserEntity> userEntityOptional = userRepository.findByMail(loginRequest.getMail());
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            if (passwordEncoder.matches(loginRequest.getPwd(), userEntity.getPwd())) {
                String userMail = String.valueOf(userEntity.getMail());
                String jwtToken = jwtTokenProvider.generateToken(userMail);

                return new LoginResponse(true, "로그인 성공", userMail, jwtToken);
            } else {
                return new LoginResponse(false, "비밀번호가 일치하지 않습니다");
            }
        } else{
            return new LoginResponse(false, "등록되지 않은 이메일입니다");
        }
    }
/*
    public Long join(User user){
        validateDuplicateUser(user); // 중복회원 검증 (ctrl + t)
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByMail(user.getMail())
                .ifPresent(u -> {
                throw new IllegalStateException("이미 존재하는 회원");
                });
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
*/

}
