package schedule.models.dto.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskPayload {
    private String title;
    private Date begin;
    private Date end;
    private String notes;
    private Date deadline;
    private Long project;
    private Integer position;
}
