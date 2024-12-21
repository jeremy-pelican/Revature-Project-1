package java.com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.example.entity.Account;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsername(String username);

    Optional<Account> findByPassword(String password);

    Optional<Account> findByUsernameAndPassword(String username, String password);
}
