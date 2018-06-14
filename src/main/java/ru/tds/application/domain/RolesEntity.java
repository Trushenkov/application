package ru.tds.application.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "public", catalog = "SimpleDataBase")
public class RolesEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "role_name")
    private String roleName;

    @Basic
    @Column(name = "role_description")
    private String roleDescription;

    @Override
    public String toString() {
        return String.format(
                "Role [id=%d, roleName='%s', roleDescription='%s'] <br>",
                id, roleName, roleDescription);
    }

    public RolesEntity(int id, String roleName, String roleDescription) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public RolesEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


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
