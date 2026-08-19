package checklist.proto.service;

import checklist.proto.model.Task;
import checklist.proto.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    final private  TaskRepository taskRepository;

    @Autowired
    ChecklistService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;

    }

    public Task findById(Long id){
        return taskRepository.getOne(id);
    };

    public List<Task> findAll(){

        return taskRepository.findAll();
    };

    public Task saveTask(Task task){

        return taskRepository.save(task);
    };

    public void deleteById(Long id){

        taskRepository.deleteById(id);

    };

}

