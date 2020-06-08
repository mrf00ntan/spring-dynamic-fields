package kz.eserzhanov.dynamic_field.dynamic_field.database.repository;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.FieldUserData;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.QFieldUserData;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldUserDataRepository extends ExCustomRepository<FieldUserData, QFieldUserData, Long>{
}
