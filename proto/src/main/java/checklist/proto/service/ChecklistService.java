package checklist.proto.service;

import checklist.proto.model.Task;
import checklist.proto.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChecklistService {

    final private TaskRepository taskRepository;

    @Autowired
    ChecklistService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }

    public Task findById(Long id) {
        return taskRepository.getOne(id);
    }

    ;

    public List<Task> findAllSorted() {

        return taskRepository.findAllByOrderByIsDoneAsc();
    }


    public Task saveTask(Task task) {

        return taskRepository.save(task);
    }


    @Transactional
    public void deleteById(Long id) {

        taskRepository.deleteById(id);

    }

    @Transactional
    public void deleteAllById() {
        taskRepository.deleteAll();
    }

    public void markAsDone(Task task) {
        task.setDone(!task.getIsDone());
        taskRepository.save(task);
    }
}

