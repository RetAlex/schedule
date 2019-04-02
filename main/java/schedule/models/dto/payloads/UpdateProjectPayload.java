package schedule.models.dto.payloads;

import lombok.Data;

@Data
public class UpdateProjectPayload {
    private String name;
    private String color;
    private Long deadline;
}
