package br.com.saimon.javatodo.models.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class WorkToDo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date datetime;

    @Column(nullable = false)
    private String homework;
    private boolean checkWork;

    WorkToDo(){

    }

    public WorkToDo(Date datetime, String homework, boolean checkWork) {
        this.datetime = datetime;
        this.homework = homework;
        this.checkWork = checkWork;
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

    public boolean isCheckWork() {
        return checkWork;
    }

    public void setCheckWork(boolean checkWork) {
        this.checkWork = checkWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkToDo)) return false;
        WorkToDo work = (WorkToDo) o;
        return getId() == work.getId() && isCheckWork() == work.isCheckWork() && Objects.equals(getDatetime(), work.getDatetime()) && Objects.equals(getHomework(), work.getHomework());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDatetime(), getHomework(), isCheckWork());
    }
}
