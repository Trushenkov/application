package ru.tds.application.mappings;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "public", catalog = "SimpleDataBase")
public class LogEntity {
    private int id;
    private int user;
    private Date dateLogin;
    private Date dateLogout;

    @Override
    public String toString() {
        return String.format(
                "LogEntity[id=%d, user='%s', dateLogin='%s', dateLogout='%s']",
                id, user, dateLogin, dateLogout);
    }

    public LogEntity() {
    }

    public LogEntity(int id, int user, Date dateLogin, Date dateLogout) {
        this.id = id;
        this.user = user;
        this.dateLogin = dateLogin;
        this.dateLogout = dateLogout;
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
    @Column(name = "user")
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Basic
    @Column(name = "date_login")
    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    @Basic
    @Column(name = "date_logout")
    public Date getDateLogout() {
        return dateLogout;
    }

    public void setDateLogout(Date dateLogout) {
        this.dateLogout = dateLogout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return id == logEntity.id &&
                user == logEntity.user &&
                Objects.equals(dateLogin, logEntity.dateLogin) &&
                Objects.equals(dateLogout, logEntity.dateLogout);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, dateLogin, dateLogout);
    }
}
