package flyinginc.flyingbagel.domain.mapper;

import flyinginc.flyingbagel.domain.model.Airport;
import flyinginc.flyingbagel.persistence.entity.AirportEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = { AirlineMapper.class })
public interface AirportMapper {

    Airport toDomain(AirportEntity entity);

    AirportEntity toEntity(Airport domain);

    List<Airport> toDomainList(List<AirportEntity> entities);
}
