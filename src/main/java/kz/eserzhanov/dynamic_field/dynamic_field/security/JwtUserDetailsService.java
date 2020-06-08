package kz.eserzhanov.dynamic_field.dynamic_field.security;

import kz.eserzhanov.dynamic_field.dynamic_field.security.jwt.JwtUserFactory;
import kz.eserzhanov.dynamic_field.dynamic_field.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return JwtUserFactory.create(userService.getByEmail(email));
    }
}
