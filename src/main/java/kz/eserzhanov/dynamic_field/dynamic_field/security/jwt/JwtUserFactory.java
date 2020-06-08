package kz.eserzhanov.dynamic_field.dynamic_field.security.jwt;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.dir.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());

        return new JwtUser(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            mapToGrantedAuthorities(roles),
            user.getUserStatus()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRoleName())
                ).collect(Collectors.toList());
    }
}
