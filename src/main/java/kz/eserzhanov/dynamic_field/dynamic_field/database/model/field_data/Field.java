package kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "field", schema = "fields")
@Data
public class Field extends BaseModel {
    private String type;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "field")
    @JsonIgnore
    private FieldUserData fieldUserData;
}
