package io.github.nikromaniuk.greed_dungeon.user;

import io.github.nikromaniuk.greed_dungeon.user.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService service;

    public UserController(UserService userService)
    {
        this.service = userService;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers()
    {
        return service.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateDto request)
    {
        service.createUser(request);
    }
}
