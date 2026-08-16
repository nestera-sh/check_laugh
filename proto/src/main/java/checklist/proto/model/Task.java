package checklist.proto.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Audited;

@Data
@Entity
@Audited.Table(name="checlistdatabase")
public class Task {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    private String title;
    private String comment;

    @Column(name="done")
    private boolean isDone;


    //геттеров сеттеров нет т.к. используем lombok
}
