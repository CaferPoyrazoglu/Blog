package com.godie.Blog.model.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

/**
 * Represents a user entity named {@link UserEntity} in the system.
 * This entity stores user-related information such as email, password, and personal details.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PROFILE_PICTURE")
    private String profilePicture;

    @Column(name = "IS_ADMIN")
    private Boolean isAdmin;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;
}
