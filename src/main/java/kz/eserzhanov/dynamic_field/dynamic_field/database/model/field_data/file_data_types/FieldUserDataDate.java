package kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.file_data_types;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "field_user_data_date", schema = "fields")
@Data
public class FieldUserDataDate extends BaseModel {
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date value;
}
