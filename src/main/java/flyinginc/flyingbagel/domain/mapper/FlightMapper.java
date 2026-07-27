package flyinginc.flyingbagel.domain.mapper;

import flyinginc.flyingbagel.domain.model.Flight;
import flyinginc.flyingbagel.persistence.entity.FlightEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {


    @Mapping(source = "airline.id", target = "airlineId")
    @Mapping(source = "airline.name", target = "airlineName")
    Flight toDomain(FlightEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "airline", ignore = true)
    FlightEntity toEntity(Flight domain);

    List<Flight> toDomainList(List<FlightEntity> entities);
}