package flyinginc.flyingbagel.service;

import flyinginc.flyingbagel.domain.mapper.FlightMapper;
import flyinginc.flyingbagel.domain.model.Flight;
import flyinginc.flyingbagel.persistence.entity.AirlineEntity;
import flyinginc.flyingbagel.persistence.entity.FlightEntity;
import flyinginc.flyingbagel.persistence.repository.AirlineRepository;
import flyinginc.flyingbagel.persistence.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirlineRepository airlineRepository;
    private final FlightMapper flightMapper;

    public FlightService(FlightRepository flightRepository, AirlineRepository airlineRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.airlineRepository = airlineRepository;
        this.flightMapper = flightMapper;
    }

    @Transactional
    public Optional<Flight> save(Flight flight) {

        Optional<AirlineEntity> airlineOpt = airlineRepository.findById(flight.getAirlineId());

        if (airlineOpt.isEmpty()) {
            return Optional.empty();
        }

        FlightEntity entity = flightMapper.toEntity(flight);
        entity.setAirline(airlineOpt.get());

        FlightEntity savedEntity = flightRepository.save(entity);
        return Optional.of(flightMapper.toDomain(savedEntity));
    }

    @Transactional(readOnly = true)
    public List<Flight> findAll() {
        return flightMapper.toDomainList(flightRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Flight> findById(Integer id) {
        return flightRepository.findById(id).map(flightMapper::toDomain);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }
}