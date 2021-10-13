package com.example.educationcenter.security;

import com.example.educationcenter.model.User;
import com.example.educationcenter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byEmail=userRepository.findByEmail(s);
        if (!byEmail.isPresent()){
            throw new UsernameNotFoundException("User with"+s+"username dose not exists");
        }
        return new CurrentUser(byEmail.get());
    }
}
