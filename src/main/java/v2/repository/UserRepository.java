package v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.UserV2;

@Repository
public interface UserRepository extends JpaRepository<UserV2, Integer> {
}
