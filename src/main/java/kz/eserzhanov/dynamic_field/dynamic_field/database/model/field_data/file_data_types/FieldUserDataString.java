package kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.file_data_types;

import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "field_user_data_string", schema = "fields")
@Data
public class FieldUserDataString extends BaseModel {
    private String value;
}
