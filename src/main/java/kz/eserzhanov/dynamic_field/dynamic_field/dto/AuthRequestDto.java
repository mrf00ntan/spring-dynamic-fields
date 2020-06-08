package kz.eserzhanov.dynamic_field.dynamic_field.dto;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String email;
    private String password;
}
