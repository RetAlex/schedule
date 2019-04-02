package schedule.models.dto.payloads;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateTaskPayload {
    @NotNull
    private String title;
    private Long start;
    private Long end;
    private String notes;
    private Long deadline;
    private long project;
}
