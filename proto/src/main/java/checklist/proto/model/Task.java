package checklist.proto.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Audited;

@Data
@Entity
@Table(name="tasks")
public class Task {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    private String title;
    private String comment;

    @Column(name="done")
    private Boolean isDone = false;

    public void setDone(Boolean done) {
        isDone = done;
    }

    //геттеров сеттеров нет т.к. используем lombok
}
