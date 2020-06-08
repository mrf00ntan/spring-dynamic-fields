package kz.eserzhanov.dynamic_field.dynamic_field.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {
    private final Long id;
    private final String email;
    private final String password;
    private final UserStatus status;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            Long id,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            UserStatus status
    ){
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return status == UserStatus.ACTIVE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
