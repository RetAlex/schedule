package schedule.models.dto.responces;

import lombok.Data;

@Data
public class IdResponse {
    private long id;

    public IdResponse(long id) {
        this.id = id;
    }
}
