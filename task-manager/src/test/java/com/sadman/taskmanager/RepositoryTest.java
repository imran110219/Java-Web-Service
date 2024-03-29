package com.sadman.taskmanager;

import com.sadman.taskmanager.model.*;
import com.sadman.taskmanager.repository.ProjectRepository;
import com.sadman.taskmanager.repository.RoleRepository;
import com.sadman.taskmanager.repository.TaskRepository;
import com.sadman.taskmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sadman
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void saveProjectRepositoryTest(){
        Project project = new Project();
        project.setName("Project 1");
        project.setUser(userRepository.getById(1));
        Project newProject = projectRepository.save(project);
        System.out.println(newProject.getName());
    }

    @Test
    public void saveTaskRepositoryTest(){
        Task task = new Task();
        task.setName("Task 1");
        task.setProject(projectRepository.getById(1));
        task.setUser(userRepository.getById(1));
        task.setStatus(Status.OPEN);
        task.setDescription("Task 1 Description");
        Task newTask = taskRepository.save(task);
        System.out.println("Task: " + newTask.getName() + " Project" + newTask.getProject().getName());
        Task existTask = taskRepository.getById(newTask.getId());

        assertThat(task.getId()).isEqualTo(existTask.getId());
    }

    @Test
    public void saveUserRepositoryTest(){
        User user = new User();
        user.setFirstName("Mr");
        user.setLastName("John");
        user.setEmail("admin@gmail.com");
        user.setUserName("admin");
        user.setPassword("12345678");
        user.setRole(roleRepository.getById(1));
        User newUser = userRepository.save(user);
        System.out.println(newUser.getFirstName() + " " + newUser.getLastName());
    }

    @Test
    public void getAllProjectsTest() {
        List<Project> projectList = projectRepository.findAll();
        for (Project project : projectList) {
            System.out.println(project.getName());
        }
    }

    @Test
    public void getAllTasksTest() {
        List<Task> taskList = taskRepository.findAll();
        for (Task task : taskList) {
            System.out.println(task.getName() + " " + task.getStatus());
        }
    }

    @Test
    public void getAllTasksByProjectIdTest() {
        List<Task> taskList = taskRepository.findAllByProjectId(1);
        for (Task task : taskList) {
            System.out.println(task.getName() + " " + task.getStatus());
        }
    }

    @Test
    public void getAllTasksByStatusTest() {
        List<Task> taskList = taskRepository.findAllByStatus(Status.OPEN);
        for (Task task : taskList) {
            System.out.println(task.getName() + " " + task.getStatus());
        }
    }

    @Test
    public void getAllExpiredTasksByStatusTest() {
        List<Task> taskList = taskRepository.findExpiredTasks();
        for (Task task : taskList) {
            if(task.getStatus().equals(Status.OPEN))
                System.out.println(task.getName() + " " + task.getStatus());
        }
    }

    @Test
    public void getAllUsersTest() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }

    @Test
    public void getAllRolesTest() {
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            System.out.println(role.getName());
        }
    }
}
