package kz.eserzhanov.dynamic_field.dynamic_field.controller;

import kz.eserzhanov.dynamic_field.dynamic_field.exception.MapException;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.SelfException;
import kz.eserzhanov.dynamic_field.dynamic_field.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/field")
public class FieldRestController {
    private final UserService userService;
    private final MapException mapException;

    @Autowired
    public FieldRestController(UserService userService, MapException mapException) {
        this.userService = userService;
        this.mapException = mapException;
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity getByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userId).getFields());
        } catch (SelfException e){
            Map<String, String> map = e.getErrorMap();
            return mapException.getErrorResponse(map);
        }
    }
}
