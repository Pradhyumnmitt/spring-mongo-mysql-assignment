package com.example.springbootmysql.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ProjectModel {

    private String projectName;
    private String projectDuration;
    private String projectType;
    private String email;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(String projectDuration) {
        this.projectDuration = projectDuration;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
