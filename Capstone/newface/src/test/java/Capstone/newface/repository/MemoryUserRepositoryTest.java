package Capstone.newface.repository;

import Capstone.newface.domain.User;
import Capstone.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Capstone.repository.MemoryUserRepository.store;
import static org.assertj.core.api.Assertions.*;

class MemoryUserRepositoryTest {

    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        User user = new User();
        user.setMail("tmddjr_0331@naver.com");

        repository.save(user);
        User result = repository.findByMail(user.getMail()).get();
        //System.out.println("result = " + (result == user)); 매번 이런식으로 검증하기 힘드니
        //Assertions.assertEquals(user, result); //expected, actual
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void findByMail(){
        User user1 = new User();
        user1.setMail("tmddjr_0331@naver.com");
        repository.save(user1);

        User user2 = new User();
        user2.setMail("tmddjr_0331@naver.commmm");
        repository.save(user2);

        User result = repository.findByMail("tmddjr_0331@naver.com").get();

        assertThat(result).isEqualTo(user1);
    }
    @Test
    public void findAll(){
        User user1 = new User();
        user1.setMail("tmddjr_0331@naver.com");
        repository.save(user1);

        User user2 = new User();
        user2.setMail("tmddjr_0331@naver.com");
        repository.save(user2);

        List<User> result = repository.findAll();
        assertThat(result).hasSize(2);
    }
}
