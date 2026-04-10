package nicolagraziani.U5_W1_D5.repositories;

import nicolagraziani.U5_W1_D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //    DERIVED QUERIES
//    EMAIL
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

//    User findByUsername(String username);
//    User findById(long userId);
}
