package io.github.nikromaniuk.greed_dungeon.user;

import io.github.nikromaniuk.greed_dungeon.user.dto.UserCreateDto;
import io.github.nikromaniuk.greed_dungeon.user.dto.UserResponseDto;
import io.github.nikromaniuk.greed_dungeon.user.mappers.UserPersistenceMapper;
import io.github.nikromaniuk.greed_dungeon.user.mappers.UserWebMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final UserWebMapper userWebMapper;
    private final UserPersistenceMapper userPersistenceMapper;

    public UserService(
            UserRepository userRepository,
            UserWebMapper userWebMapper,
            UserPersistenceMapper userPersistenceMapper)
    {
        this.userRepository = userRepository;
        this.userWebMapper = userWebMapper;
        this.userPersistenceMapper = userPersistenceMapper;
    }

    public List<UserResponseDto> getAllUsers()
    {
        List<UserEntity> entities = userRepository.findAll();

        List<User> domains = entities.stream()
                .map(userPersistenceMapper::toDomain)
                .toList();

        return domains.stream()
                .map(userWebMapper::toResponse)
                .toList();
    }

    public void createUser(UserCreateDto dto)
    {
        if (dto == null) { return; }

        if (userRepository.findByEmail(dto.email()).isPresent())
        {
            throw new RuntimeException("User with requested email already exists");
        }

        // DTO -> Domain
        User domain = userWebMapper.toDomain(dto);

        // Domain -> Entity
        UserEntity entity = userPersistenceMapper.toEntity(domain);

        // Save Entity
        userRepository.save(entity);
    }

    public User getDomainUser(Long userId)
    {
        UserEntity foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Requested User not found"));

        return userPersistenceMapper.toDomain(foundUser);
    }
}
