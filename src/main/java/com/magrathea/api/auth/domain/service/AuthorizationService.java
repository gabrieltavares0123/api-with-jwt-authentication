package com.magrathea.api.auth.domain.service;

import com.magrathea.api.auth.data.repository.UserRepository;
import com.magrathea.api.auth.exception.UserNameIsBlankException;
import com.magrathea.api.auth.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNameIsBlankException, UserNotFoundException {
        if (username.isBlank()) throw new UserNameIsBlankException();
        var user = userRepository.findByUsername(username);
        if (user == null) throw new UserNotFoundException();
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), user.getAuthorities());
    }
}
