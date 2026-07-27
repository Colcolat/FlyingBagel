package flyinginc.flyingbagel.persistence.repository;

import flyinginc.flyingbagel.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
