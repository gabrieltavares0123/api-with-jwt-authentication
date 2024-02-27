package com.magrathea.api.auth.domain.service;

import com.magrathea.api.auth.data.entity.UserEntity;
import com.magrathea.api.auth.data.repository.UserRepository;
import com.magrathea.api.auth.domain.dto.AuthenticationRequestDTO;
import com.magrathea.api.auth.domain.dto.AuthenticationResponseDTO;
import com.magrathea.api.auth.domain.dto.RegisterRequestDTO;
import com.magrathea.api.auth.exception.UserNameIsBlankException;
import com.magrathea.api.auth.exception.UserPasswordIsBlankException;
import com.magrathea.api.auth.exception.UserRoleIsNullException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public AuthenticationResponseDTO login(AuthenticationRequestDTO authenticationRequestDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequestDTO.username(), authenticationRequestDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());
        return new AuthenticationResponseDTO(token);
    }

    public void register(RegisterRequestDTO registerRequestDTO) throws UserNameIsBlankException, UserPasswordIsBlankException, UserRoleIsNullException {
        if (registerRequestDTO.username().isBlank()) throw new UserNameIsBlankException();
        if (registerRequestDTO.password().isBlank()) throw new UserPasswordIsBlankException();
        if (registerRequestDTO.role() == null) throw new UserRoleIsNullException();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerRequestDTO.password());
        UserEntity newUser = new UserEntity(null, registerRequestDTO.username(), encryptedPassword, registerRequestDTO.role());

        this.userRepository.save(newUser);
    }
}
