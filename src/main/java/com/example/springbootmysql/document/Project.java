package com.example.springbootmysql.document;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String projectName;
    private String projectDuration;
    private String projectType;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
