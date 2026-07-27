package flyinginc.flyingbagel.domain.mapper;

import flyinginc.flyingbagel.domain.model.Airline;
import flyinginc.flyingbagel.persistence.entity.AirlineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = { FlightMapper.class })
public interface AirlineMapper {

    Airline toDomain(AirlineEntity entity);

    @Mapping(target = "flights", ignore = true)
    AirlineEntity toEntity(Airline domain);

    List<Airline> toDomainList(List<AirlineEntity> entities);
}