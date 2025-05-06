package Capstone.newface.service;

import Capstone.newface.domain.User;
import Capstone.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    UserService userService = new UserService();
    MemoryUserRepository memoryUserRepository = new MemoryUserRepository();

    @AfterEach
    public void afterEach(){
        memoryUserRepository.clearStore();
    }



    @Test
    void join() {
        //given
        User user = new User();
        user.setMail("tmddjr_0331@naver.com");
        //when
        Long saveId = userService.join(user);
        //then
        User findUser = userService.findOne(saveId).get();
        assertThat(user.getMail()).isEqualTo(findUser.getMail());
    }

    @Test
    public void 중복회원예외(){
        //given
        User user1 = new User();
        user1.setMail("Spring");

        User user2 = new User();
        user2.setMail("Spring");

        //when
        userService.join(user1);


       /* try {
            userService.join(user2);
            fail("테스트 검증 실패");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
        }*/
    }

    @Test
    void findUsers() {
    }

    @Test
    void findOne() {
    }
}