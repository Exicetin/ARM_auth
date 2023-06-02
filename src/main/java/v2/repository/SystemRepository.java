package v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.System;

@Repository
public interface SystemRepository extends JpaRepository<System, Integer> {

}
