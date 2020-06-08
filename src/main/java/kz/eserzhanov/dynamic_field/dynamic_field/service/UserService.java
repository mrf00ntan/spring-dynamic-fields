package kz.eserzhanov.dynamic_field.dynamic_field.service;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.SelfException;

public interface UserService {
    Boolean checkByEmail(String email);
    User getByEmail(String email) throws SelfException;
    Boolean checkById(Long id);
    User getById(Long id) throws SelfException;
    Boolean save(User user);
}
