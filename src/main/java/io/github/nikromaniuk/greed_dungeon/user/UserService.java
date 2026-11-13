package io.github.nikromaniuk.greed_dungeon.user;

import io.github.nikromaniuk.greed_dungeon.user.dto.UserAuthDto;
import io.github.nikromaniuk.greed_dungeon.user.dto.UserCreateDto;
import io.github.nikromaniuk.greed_dungeon.user.dto.UserResponseDto;
import io.github.nikromaniuk.greed_dungeon.user.mappers.UserPersistenceMapper;
import io.github.nikromaniuk.greed_dungeon.user.mappers.UserWebMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final UserWebMapper userWebMapper;
    private final UserPersistenceMapper userPersistenceMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            UserWebMapper userWebMapper,
            UserPersistenceMapper userPersistenceMapper,
            PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.userWebMapper = userWebMapper;
        this.userPersistenceMapper = userPersistenceMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> getAllUsers()
    {
        List<UserEntity> userEntities = userRepository.findAll();

        List<User> users = userEntities.stream()
                .map(userPersistenceMapper::toDomain)
                .toList();

        return users.stream()
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
        User user = userWebMapper.toDomain(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));

        // Domain -> Entity
        UserEntity userEntity = userPersistenceMapper.toEntity(user);

        // Save Entity
        userRepository.save(userEntity);
    }

    public boolean authUser(UserAuthDto dto)
    {
        User user = getUserByEmail(dto.email());

        return passwordEncoder.matches(dto.password(), user.getPassword());
    }

    public User getUserById(Long id)
    {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requested User not found"));

        return userPersistenceMapper.toDomain(userEntity);
    }

    public User getUserByEmail(String email)
    {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Requested User not found"));

        return userPersistenceMapper.toDomain(userEntity);
    }
}
