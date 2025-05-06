/*package Capstone.repository;

import Capstone.domain.User;
import org.junit.jupiter.api.AfterEach;

import java.util.*;

public class MemoryUserRepository1 implements UserRepository{

    public static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null값을 반환할 시
    }

    @Override
    public Optional<User> findByMail(String mail) {
        return store.values().stream()
                .filter(member -> member.getMail().equals(mail))
                .findAny(); // mail의 모든 것을 순회하면서, 들어온 mail과 같은 것의 value값(User) 반환
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values()); //values 메소드는, Map 구현체에 있는 모든 Value값을 Collections 구현체로 반환
    }

    public void clearStore(){
        store.clear();
    }
}
*/