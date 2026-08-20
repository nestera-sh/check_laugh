package checklist.proto.controller;


import checklist.proto.model.Task;
import checklist.proto.service.ChecklistService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    private final ChecklistService taskService;


    @Autowired
    TaskController(ChecklistService taskService){
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public String findAll(Model model){


        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
    };

    @GetMapping("/task-create")
    public String createTaskForm(Task task){

        return "task-create";
    };

    @PostMapping("/task-create")
    public String createTask(Task task){

        taskService.saveTask(task);
        return "redirect:/tasks";
    }
}
