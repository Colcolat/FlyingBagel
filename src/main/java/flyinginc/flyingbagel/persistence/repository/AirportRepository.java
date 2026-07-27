package flyinginc.flyingbagel.persistence.repository;

import flyinginc.flyingbagel.persistence.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, Integer> {
}
