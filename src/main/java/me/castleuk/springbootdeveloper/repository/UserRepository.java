package me.castleuk.springbootdeveloper.repository;

import java.util.Optional;
import me.castleuk.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //이메일로 사용자 정보를 가져옴
}
