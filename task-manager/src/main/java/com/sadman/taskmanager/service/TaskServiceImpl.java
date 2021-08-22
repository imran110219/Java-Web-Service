package com.sadman.taskmanager.service;

import com.sadman.taskmanager.exception.RecordNotFoundException;
import com.sadman.taskmanager.iservice.TaskService;
import com.sadman.taskmanager.model.Status;
import com.sadman.taskmanager.model.Task;
import com.sadman.taskmanager.repository.ProjectRepository;
import com.sadman.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository repository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<Task> getAllTasksByProjectId(int projectId) {
        return repository.findAllByProjectId(projectId);
    }

    @Override
    public List<Task> getAllTasksByUserId(int userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public List<Task> getAllTasksByStatus(String status) {
        switch (status){
            case "open" : return repository.findAllByStatus(Status.OPEN);
            case "inprogress" : return repository.findAllByStatus(Status.INPROGESS);
            case "closed" : return repository.findAllByStatus(Status.CLOSED);
            default: return null;
        }
    }

    @Override
    public List<Task> getAllExpiredTasksByStatus(String status) {
        List<Task> allExpiredTasks = repository.findExpiredTasks();
        List<Task> finalTasks = new ArrayList<>();
        if(status.equals("open")){
            for (Task task : allExpiredTasks) {
                if(task.getStatus().equals(Status.OPEN)){
                    finalTasks.add(task);
                }
            }
        }
        else if(status.equals("inprogress")){
            for (Task task : allExpiredTasks) {
                if(task.getStatus().equals(Status.INPROGESS)){
                    finalTasks.add(task);
                }
            }
        }
        else {
            for (Task task : allExpiredTasks) {
                if(task.getStatus().equals(Status.CLOSED)){
                    finalTasks.add(task);
                }
            }
        }
        return finalTasks;
    }

    @Override
    public Task getTaskById(int id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Task newTask, int id) {
        return repository.findById(id)
                .map(Task -> {
                    Task.setName(newTask.getName());
                    Task.setProject(newTask.getProject());
                    Task.setUser(newTask.getUser());
                    Task.setStatus(newTask.getStatus());
                    Task.setDescription(newTask.getDescription());
                    Task.setCreateDate(newTask.getCreateDate());
                    Task.setStartDate(newTask.getStartDate());
                    Task.setEndDate(newTask.getEndDate());
                    return repository.save(Task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });
    }

    @Override
    public void deleteTaskById(int id) {
        repository.deleteById(id);
    }
}
