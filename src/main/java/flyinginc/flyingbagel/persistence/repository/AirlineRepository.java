package flyinginc.flyingbagel.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import flyinginc.flyingbagel.persistence.entity.AirlineEntity;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Integer> {
// TODO: Add missing methods
}