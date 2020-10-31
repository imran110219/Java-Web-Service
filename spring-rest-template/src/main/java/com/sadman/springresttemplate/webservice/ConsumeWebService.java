package com.sadman.springresttemplate.webservice;

import com.sadman.springresttemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Sadman
 */
@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/template/employees")
    public String getEmployeeList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/employees", HttpMethod.GET, entity, String.class).getBody();
    }

    @GetMapping(value = "/template/employees/{id}")
    public String getEmployee(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/employees/"+id, HttpMethod.GET, entity, String.class).getBody();
    }

    @PostMapping(value = "/template/employees")
    public String createEmployee(@RequestBody Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);

        return restTemplate.exchange("http://localhost:8080/employees", HttpMethod.POST, entity, String.class).getBody();
    }

    @PutMapping(value = "/template/employees/{id}")
    public String updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);

        return restTemplate.exchange("http://localhost:8080/employees/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping(value = "/template/employees/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);

        return restTemplate.exchange("http://localhost:8080/employees/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
