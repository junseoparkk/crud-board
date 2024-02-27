package toy.crudboard.question;

import jakarta.transaction.Transactional;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.crudboard.user.entity.User;
import toy.crudboard.user.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("123");
        user.setEmail("testEmail@naver.com");
        userRepository.save(user);
    }

    @Transactional
    @DisplayName("유저 이름으로 유저 찾는 기능 테스트")
    @Test
    void testFindByUsername() {
        //when
        Optional<User> findUser = userRepository.findByUsername("testUser");

        //then
        Assertions.assertThat(findUser).isNotEmpty();
    }
}
