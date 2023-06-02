package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.NSIDefOrders;

@Repository
public interface TemplatesRepository extends JpaRepository<NSIDefOrders, Integer> {
}
