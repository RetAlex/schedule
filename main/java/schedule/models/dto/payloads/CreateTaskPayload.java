package schedule.models.dto.payloads;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateTaskPayload {
    @NotNull
    private String title;
    private Date start;
    private Date end;
    private String notes;
    private Date deadline;
    private long project;
}
