package flyinginc.flyingbagel.domain.mapper;

import flyinginc.flyingbagel.domain.model.User;
import flyinginc.flyingbagel.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = { FlightMapper.class })
public interface UserMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);

    List<User> toDomainList(List<UserEntity> entities);

}