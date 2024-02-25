package toy.crudboard.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.crudboard.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
