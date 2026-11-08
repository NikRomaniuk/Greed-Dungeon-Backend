package io.github.nikromaniuk.greed_dungeon.user.mappers;

import io.github.nikromaniuk.greed_dungeon.user.*;
import io.github.nikromaniuk.greed_dungeon.user.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserWebMapper
{
    @Mapping(target = "id", ignore = true)
    User toDomain(UserCreateDto createDto);

    UserResponseDto toResponse(User domain);
}
