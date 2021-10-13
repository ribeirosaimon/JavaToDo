package br.com.saimon.javatodo.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class ToDo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date datetime;
    private String homework;
    private boolean check;

    public ToDo(Date datetime, String homework, boolean check) {
        this.datetime = datetime;
        this.homework = homework;
        this.check = check;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return getId() == toDo.getId() && isCheck() == toDo.isCheck() && Objects.equals(getDatetime(), toDo.getDatetime()) && Objects.equals(getHomework(), toDo.getHomework());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDatetime(), getHomework(), isCheck());
    }
}
