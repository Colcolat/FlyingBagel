package flyinginc.flyingbagel.persistence.repository;

import flyinginc.flyingbagel.persistence.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<FlightEntity, Integer> {
    //TODO: Add custom query methods if needed
}
