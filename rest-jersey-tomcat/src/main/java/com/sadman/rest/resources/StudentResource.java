package com.sadman.rest.resources;

import com.sadman.rest.model.Student;
import com.sadman.rest.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    private StudentService studentService = new StudentService();

    @GET
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @POST
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @GET
    @Path("/{userName}")
    public Student getStudent(@PathParam("userName") String userName) {
        return studentService.getStudent(userName);
    }

    @PUT
    @Path("/{userName}")
    public Student updateStudent(@PathParam("userName") String userName, Student student) {
        student.setUserName(userName);
        return studentService.updateStudent(student);
    }

    @DELETE
    @Path("/{userName}")
    public void deleteStudent(@PathParam("userName") String userName) {
        studentService.removeStudent(userName);
    }
}
