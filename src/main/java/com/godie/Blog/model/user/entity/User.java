package com.godie.Blog.model.user.entity;

import com.godie.Blog.model.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

/**
 * Represents a user entity named {@link User} in the system.
 * This entity stores user-related information such as email, password, and personal details.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
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

}
