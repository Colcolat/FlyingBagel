package flyinginc.flyingbagel.service;

import flyinginc.flyingbagel.domain.mapper.AirlineMapper;
import flyinginc.flyingbagel.domain.model.Airline;
import flyinginc.flyingbagel.persistence.entity.AirlineEntity;
import flyinginc.flyingbagel.persistence.repository.AirlineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;

    public AirlineService(AirlineRepository airlineRepository, AirlineMapper airlineMapper) {
        this.airlineRepository = airlineRepository;
        this.airlineMapper = airlineMapper;
    }

    @Transactional
    public Airline save(Airline airline) {
        AirlineEntity entity = airlineMapper.toEntity(airline);

        if (entity.getFlights() != null && !entity.getFlights().isEmpty()) {
            entity.getFlights().forEach(flight -> flight.setAirline(entity));
        }

        AirlineEntity savedEntity = airlineRepository.save(entity);
        return airlineMapper.toDomain(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<Airline> findAll() {
        return airlineMapper.toDomainList(airlineRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Airline> findById(Integer id) {
        return airlineRepository.findById(id).map(airlineMapper::toDomain);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (airlineRepository.existsById(id)) {
            airlineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}