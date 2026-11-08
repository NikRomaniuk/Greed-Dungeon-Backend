package io.github.nikromaniuk.greed_dungeon.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 254) // 256 Excluding "<" ... ">"
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
