package io.github.nikromaniuk.greed_dungeon.user.dto;

public record UserCreateDto(
        String name,
        String email,
        String password)
{

}
