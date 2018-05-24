package ru.tds.application.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "public", catalog = "SimpleDataBase")
public class LogEntity {
    private int id;
    private Date dateLogin;
    private Date dateLogout;
    private Integer userss;


    @Override
    public String toString() {
        return String.format(
                "Log [id=%d, dateLogin='%s', dateLogout='%s', userss='%s'] <br>",
                id, dateLogin, dateLogout, userss);
    }

    public LogEntity() {
    }

    public LogEntity(int id, Date dateLogin, Date dateLogout, Integer userss) {

        this.id = id;
        this.dateLogin = dateLogin;
        this.dateLogout = dateLogout;
        this.userss = userss;
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

    @Basic
    @Column(name = "userss")
    public Integer getUserss() {
        return userss;
    }

    public void setUserss(Integer userss) {
        this.userss = userss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return id == logEntity.id &&
                Objects.equals(dateLogin, logEntity.dateLogin) &&
                Objects.equals(dateLogout, logEntity.dateLogout) &&
                Objects.equals(userss, logEntity.userss);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateLogin, dateLogout, userss);
    }
}
