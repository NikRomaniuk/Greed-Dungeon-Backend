package io.github.nikromaniuk.greed_dungeon.user;

import io.github.nikromaniuk.greed_dungeon.user.dto.UserAuthDto;
import io.github.nikromaniuk.greed_dungeon.user.dto.UserCreateDto;
import io.github.nikromaniuk.greed_dungeon.user.dto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserCreateDto request)
    {
        service.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody UserAuthDto authDto) {
        boolean isAuthenticated = service.authUser(authDto);

        if (isAuthenticated)
        {
            return ResponseEntity.ok("Authentication successful!");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
