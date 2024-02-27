package com.magrathea.api.auth.data.repository;

import com.magrathea.api.auth.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findByUsername(String username);
}
