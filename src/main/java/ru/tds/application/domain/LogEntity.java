package ru.tds.application.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "public", catalog = "SimpleDataBase")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "date_login")
    private Time dateLogin;

    @Basic
    @Column(name = "date_logout")
    private Time dateLogout;

    @Basic
    @Column(name = "user_login")
    private String userLogin;

    public LogEntity() {

    }

    public LogEntity(int id, Time dateLogin, Time dateLogout, String userLogin) {
        this.id = id;
        this.dateLogin = dateLogin;
        this.dateLogout = dateLogout;
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Time getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Time dateLogin) {
        this.dateLogin = dateLogin;
    }


    public Time getDateLogout() {
        return dateLogout;
    }

    public void setDateLogout(Time dateLogout) {
        this.dateLogout = dateLogout;
    }


    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return String.format(
                "Log [id=%d, dateLogin='%s', dateLogout='%s', user_login='%s'] <br>",
                id, dateLogin, dateLogout, userLogin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return id == logEntity.id &&
                Objects.equals(dateLogin, logEntity.dateLogin) &&
                Objects.equals(dateLogout, logEntity.dateLogout) &&
                Objects.equals(userLogin, logEntity.userLogin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateLogin, dateLogout, userLogin);
    }
}
