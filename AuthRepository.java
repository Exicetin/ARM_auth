package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Auth findBylogin(String login);
}