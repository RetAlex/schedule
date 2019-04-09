package schedule.models.dto.payloads;

import lombok.Data;

@Data
public class UpdateTaskPayload {
    private String title;
    private Long begin;
    private Long end;
    private String notes;
    private Long deadline;
    private Long project;
    private Integer position;
    private Long list;
}
