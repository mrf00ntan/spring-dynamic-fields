package kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.file_data_types.FieldUserDataDate;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.file_data_types.FieldUserDataLong;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.file_data_types.FieldUserDataString;
import lombok.Data;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "field_user_data", schema = "fields")
@Data
public class FieldUserData extends BaseModel {

    @Cascade( org.hibernate.annotations.CascadeType.ALL )
    @Any( metaColumn = @Column( name = "value_type" ), fetch = FetchType.EAGER)
    @AnyMetaDef(
            idType = "long",
            metaType = "string",
            metaValues = {
                    @MetaValue( value = "StringProperty", targetEntity = FieldUserDataString.class ),
                    @MetaValue( value = "LongProperty", targetEntity = FieldUserDataLong.class ),
                    @MetaValue( value = "DateProperty", targetEntity = FieldUserDataDate.class )
            })
    @JoinColumn( name = "value_id" )
    private Object value;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;
}
