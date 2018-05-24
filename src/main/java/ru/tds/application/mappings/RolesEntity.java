package ru.tds.application.mappings;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "public", catalog = "SimpleDataBase")
public class RolesEntity {
    private int id;
    private String roleName;
    private String roleDescription;

    @Override
    public String toString() {
        return String.format(
                "RolesEntity[id=%d, roleName='%s', roleDescription='%s']",
                id, roleName, roleDescription);
    }

    public RolesEntity(int id, String roleName, String roleDescription) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public RolesEntity() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_description")
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return id == that.id &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleDescription, that.roleDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, roleDescription);
    }
}
