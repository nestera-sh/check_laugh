package checklist.proto.controller;


import checklist.proto.model.Task;
import checklist.proto.service.ChecklistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    private ChecklistService taskService;


    @GetMapping("/tasks")
    public String findAll(){



        List<Task> tasks = taskService.findAll();
        return "";
    };

}
