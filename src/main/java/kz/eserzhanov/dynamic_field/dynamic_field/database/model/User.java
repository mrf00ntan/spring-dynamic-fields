package kz.eserzhanov.dynamic_field.dynamic_field.database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.dir.Role;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.Field;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.field_data.FieldUserData;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseModel {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToOne(mappedBy = "user")
    private UserData userData;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Field> fields;
    @OneToMany(mappedBy = "user")
    private List<FieldUserData> fieldUserData;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "last_modified_date", nullable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @PreUpdate
    public void setLastUpdate() {  lastModifiedDate = new Date(); }

    @PreRemove
    public void setLastRemove() { lastModifiedDate = new Date(); }

    @PrePersist
    public void setPersist() {
        lastModifiedDate = new Date();
        createdDate = new Date();
    }
}
