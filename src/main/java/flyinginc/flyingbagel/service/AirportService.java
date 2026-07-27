package flyinginc.flyingbagel.service;

import flyinginc.flyingbagel.domain.mapper.AirportMapper;
import flyinginc.flyingbagel.domain.model.Airport;
import flyinginc.flyingbagel.persistence.entity.AirportEntity;
import flyinginc.flyingbagel.persistence.repository.AirportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public AirportService(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Transactional
    public Airport save(Airport airport) {
        AirportEntity entity = airportMapper.toEntity(airport);
        AirportEntity savedEntity = airportRepository.save(entity);
        return airportMapper.toDomain(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<Airport> findAll() {    
        return airportMapper.toDomainList(airportRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Airport> findById(Integer id) {
        return airportRepository.findById(id).map(airportMapper::toDomain);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}