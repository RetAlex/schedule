package schedule.models.dto.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProjectPayload {
    private String name;
    private Long deadline;
    private String color;

    public CreateProjectPayload() {
    }
}
