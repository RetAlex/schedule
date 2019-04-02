package schedule.services;

import org.springframework.stereotype.Service;
import schedule.models.dto.payloads.CreateTaskPayload;
import schedule.models.dto.payloads.UpdateTaskPayload;
import schedule.models.entities.Task;
import schedule.models.exceptions.NotFoundException;
import schedule.repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(CreateTaskPayload payload){
        return taskRepository.save(new Task(payload));
    }

    public void updateTask(UpdateTaskPayload payload, long id){
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        task.applyUpdates(payload);
        taskRepository.save(task);
    }
}
