package com.sadman.taskmanager.service;

import com.sadman.taskmanager.exception.RecordNotFoundException;
import com.sadman.taskmanager.iservice.ProjectService;
import com.sadman.taskmanager.model.Project;
import com.sadman.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository repository;

    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public List<Project> getAllProjectsByUserId(int userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Project getProjectById(int id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public Project createProject(Project project) {
        return repository.save(project);
    }

    @Override
    public Project updateProject(Project newProject, int id) {
        return repository.findById(id)
                .map(Project -> {
                    Project.setName(newProject.getName());
                    Project.setUser(newProject.getUser());
                    return repository.save(Project);
                })
                .orElseGet(() -> {
                    newProject.setId(id);
                    return repository.save(newProject);
                });
    }

    @Override
    public void deleteProjectById(int id) {
        repository.deleteById(id);
    }
}
