package com.sadman.springresttemplate.model;

import lombok.*;

/**
 * @author Sadman
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
