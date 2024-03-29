package com.sadman.taskmanager.controller;

import com.sadman.taskmanager.exception.RecordNotFoundException;
import com.sadman.taskmanager.iservice.TaskService;
import com.sadman.taskmanager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(Model model) {
        return service.getAllTasks();
    }

    @GetMapping("/tasks/users/{id}")
    public List<Task> getAllTasksByUserId(@PathVariable(value = "id") int userId) {
        return service.getAllTasksByUserId(userId);
    }

    @GetMapping("projects/{id}/tasks")
    public List<Task> getAllTasksByProjectId(@PathVariable(value = "id") int projectId) {
        return service.getAllTasksByProjectId(projectId);
    }

    @GetMapping("/tasks/status/{status}")
    public List<Task> getAllTasksByStatus(@PathVariable(value = "status") String status) {
        return service.getAllTasksByStatus(status);
    }

    @GetMapping("/tasks/expired/status/{status}")
    public List<Task> getAllExpiredTasksByStatus(@PathVariable(value = "status") String status) {
        return service.getAllExpiredTasksByStatus(status);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") int taskId)
            throws RecordNotFoundException {
        Task Task = service.getTaskById(taskId);
        return ResponseEntity.ok().body(Task);
    }

    @PostMapping(value = "/tasks", consumes = MediaType.ALL_VALUE)
    public Task createTask(@Valid @RequestBody Task task) {
        return service.createTask(task);
    }

    @PutMapping("/tasks/edit/{id}")
    public Task editTaskById(@RequestBody Task newTask, @PathVariable(value = "id") int taskId) {
        return service.updateTask(newTask, taskId);
    }

    @DeleteMapping("/tasks/delete/{id}")
    public void deleteTaskById(@PathVariable(value = "id") int taskId){
        service.deleteTaskById(taskId);
    }
}
