package com.example.springbootmysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeModel {
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    private List<ProjectModel> projects;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
