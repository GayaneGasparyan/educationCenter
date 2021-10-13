package com.example.educationcenter.security;

import com.example.educationcenter.model.User;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byEmail = userService.findByEmail(s);
        if (!byEmail.isPresent()) {
            throw new UsernameNotFoundException("User with " + s + " username does not exists");
        }

        return new CurrentUser(byEmail.get());
    }
}
