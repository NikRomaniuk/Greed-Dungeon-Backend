package io.github.nikromaniuk.greed_dungeon.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User
{
    // --- FIELDS ---

    private Long id;
    private String name;
    private String email;
    private String password;

    // --- CONSTRUCTORS ---

    public User(Long id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
