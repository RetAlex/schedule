package schedule.models.dto.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateProjectPayload {
    private String name;
    private String color;
    private Date deadline;
}
