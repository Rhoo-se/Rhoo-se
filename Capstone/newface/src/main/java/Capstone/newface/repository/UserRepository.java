package Capstone.newface.repository;

import Capstone.newface.domain.User;
import Capstone.newface.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMail(String mail);
}
