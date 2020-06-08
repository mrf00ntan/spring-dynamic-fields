package kz.eserzhanov.dynamic_field.dynamic_field.database.repository;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.QUser;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ExCustomRepository<User, QUser, Long>{
}
