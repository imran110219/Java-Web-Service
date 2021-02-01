package com.sadman.rest.resources;

import com.sadman.rest.model.Student;
import com.sadman.rest.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response addStudent(Student student) {
        studentService.addStudent(student);
        return Response.ok().build();
    }

    @GET
    @Path("/{userName}")
    public Student getStudent(@PathParam("userName") String userName) {
        return studentService.getStudent(userName);
    }

    @PUT
    @Path("/{userName}")
    public Response updateStudent(@PathParam("userName") String userName, Student student) {
        student.setUserName(userName);
        int count = studentService.updateStudent(student);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{userName}")
    public Response deleteStudent(@PathParam("userName") String userName) {
        int count = studentService.deleteStudent(userName);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
