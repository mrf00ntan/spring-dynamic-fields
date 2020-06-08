package kz.eserzhanov.dynamic_field.dynamic_field.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String token;
    private String roleName;
}
