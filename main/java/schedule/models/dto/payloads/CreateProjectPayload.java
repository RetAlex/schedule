package schedule.models.dto.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProjectPayload {
    private String name;
    private Date deadline;
    private String color;
}
