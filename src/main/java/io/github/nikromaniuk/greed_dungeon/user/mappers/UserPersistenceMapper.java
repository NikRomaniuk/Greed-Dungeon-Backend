package io.github.nikromaniuk.greed_dungeon.user.mappers;

import io.github.nikromaniuk.greed_dungeon.user.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper
{
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}
