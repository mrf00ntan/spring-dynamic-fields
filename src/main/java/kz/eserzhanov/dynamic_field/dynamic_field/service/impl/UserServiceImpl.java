package kz.eserzhanov.dynamic_field.dynamic_field.service.impl;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.QUser;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import kz.eserzhanov.dynamic_field.dynamic_field.database.repository.UserRepository;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.MapException;
import kz.eserzhanov.dynamic_field.dynamic_field.exception.SelfException;
import kz.eserzhanov.dynamic_field.dynamic_field.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapException mapException;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MapException mapException) {
        this.userRepository = userRepository;
        this.mapException = mapException;
    }

    @Override
    public Boolean checkByEmail(String email) {
        return userRepository.findOne(QUser.user.email.eq(email)).isPresent();
    }

    @Override
    public Boolean save(User user) {
        return userRepository.save(user).getId() != null;
    }

    @Override
    public User getByEmail(String email) throws SelfException {
        Optional<User> optional = userRepository.findOne(QUser.user.email.eq(email));
        if(optional.isPresent()){
            return optional.get();
        }
        throw new SelfException("User not found, by E-mail:" + email, mapException.getException("user", "notFound"));
    }

    @Override
    public Boolean checkById(Long id) {
        return userRepository.findOne(QUser.user.id.eq(id)).isPresent();
    }

    @Override
    public User getById(Long id) throws SelfException {
        Optional<User> optional = userRepository.findOne(QUser.user.id.eq(id));
        if(optional.isPresent()){
            return optional.get();
        }
        throw new SelfException("User not found, by userId:" + id, mapException.getException("user", "notFound"));
    }
}
