package kz.eserzhanov.dynamic_field.dynamic_field.controller;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.dir.Role;
import kz.eserzhanov.dynamic_field.dynamic_field.dto.AuthRequestDto;
import kz.eserzhanov.dynamic_field.dynamic_field.dto.AuthResponseDto;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.MapException;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.SelfException;
import kz.eserzhanov.dynamic_field.dynamic_field.security.jwt.JwtTokenProvider;
import kz.eserzhanov.dynamic_field.dynamic_field.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final MapException mapException;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthRestController(AuthenticationManager authenticationManager, UserService userService, MapException mapException, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.mapException = mapException;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthRequestDto request){
        try {
            String email = request.getEmail();
            User user = userService.getByEmail(email);
            List<Role> roles = new ArrayList<>();
            roles.add(user.getRole());
            String token = jwtTokenProvider.createToken(email, roles);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, request.getPassword()));

            AuthResponseDto authResponseDto = new AuthResponseDto();
            authResponseDto.setToken(token);
            authResponseDto.setRoleName(user.getRole().getRoleName());

            return ResponseEntity.status(HttpStatus.OK).body(authResponseDto);
        } catch (SelfException e){
            Map<String, String> map = e.getErrorMap();
            return mapException.getErrorResponse(map);
        }
    }
}
