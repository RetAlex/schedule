package schedule.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "planning_month")
public class PlanningMonth {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private Date date;
    @OneToMany(targetEntity = PlanningDay.class)
    private List<PlanningDay> days;
}
