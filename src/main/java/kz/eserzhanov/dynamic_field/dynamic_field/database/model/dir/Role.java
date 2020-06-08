package kz.eserzhanov.dynamic_field.dynamic_field.database.model.dir;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dir_roles")
@Data
public class Role extends BaseModel {
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_kz")
    private String nameKz;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> userList;
}
