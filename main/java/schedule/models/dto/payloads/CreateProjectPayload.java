package schedule.models.dto.payloads;

import lombok.Data;

@Data
public class CreateProjectPayload {
    private String name;
    private Long deadline;
    private String color;
}
