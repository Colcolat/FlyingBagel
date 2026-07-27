package flyinginc.flyingbagel.service;

import flyinginc.flyingbagel.domain.mapper.UserMapper;
import flyinginc.flyingbagel.domain.model.User;
import flyinginc.flyingbagel.persistence.entity.UserEntity;
import flyinginc.flyingbagel.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(entity);
        return userMapper.toDomain(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userMapper.toDomainList(userRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDomain);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}