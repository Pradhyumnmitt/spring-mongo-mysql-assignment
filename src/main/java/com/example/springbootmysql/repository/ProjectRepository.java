package com.example.springbootmysql.repository;

import com.example.springbootmysql.document.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

    public List<Project> findProjectByEmail(String email);

    public void deleteByEmail(String email);

}
