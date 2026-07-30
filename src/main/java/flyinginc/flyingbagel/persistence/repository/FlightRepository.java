package flyinginc.flyingbagel.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import flyinginc.flyingbagel.persistence.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {

}