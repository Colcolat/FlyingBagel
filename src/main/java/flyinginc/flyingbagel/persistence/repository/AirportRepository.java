package flyinginc.flyingbagel.persistence.repository;

import flyinginc.flyingbagel.persistence.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<FlightEntity, Integer> {

}
