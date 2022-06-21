package com.example.springbootmysql.service;
import com.example.springbootmysql.document.Project;
import com.example.springbootmysql.entity.Employee;
import com.example.springbootmysql.model.EmployeeModel;
import com.example.springbootmysql.model.ProjectModel;
import com.example.springbootmysql.repository.EmployeeRepository;
import com.example.springbootmysql.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public String createResources(EmployeeModel employeeModel)
    {
        if (!employeeRepository.existsByEmail(employeeModel.getEmail())){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeModel, employee);
            try {
                employeeRepository.save(employee);
                employeeModel.getProjects().stream().forEach(p -> {
                    Project project = new Project();
                    p.setEmail(employeeModel.getEmail());
                    BeanUtils.copyProperties(p, project);
                    try {
                        projectRepository.save(project);
                    }catch (Exception e){
                        throw e;
                    }
                });
            }catch (Exception e){
                throw e;
            }
            return "Resource added successfully!";
        }else {
            return "Duplicate resource";
        }
    }
    public List<EmployeeModel> readResources(){
        List<EmployeeModel> employees=new ArrayList<>();
        List<Employee> employeeList=new ArrayList<>();
        try{
            employeeList=employeeRepository.findAll();
        }
        catch(Exception e){
            throw e;
        }
        if(employeeList.size()>0)
        {
            employeeList.stream().forEach(e->{
                EmployeeModel employeeModel=new EmployeeModel();
                employeeModel.setFirstName(e.getFirstName());
                employeeModel.setLastName(e.getLastName());
                employeeModel.setEmail(e.getEmail());

                List<Project> projectList=new ArrayList<>();
                List<ProjectModel> projects=new ArrayList<>();
                try{
                    projectList=projectRepository.findProjectByEmail(e.getEmail());
                }
                catch(Exception err)
                {
                    throw err;
                }
                if(projectList.size()>0)
                {
                    projectList.stream().forEach(p->{
                        ProjectModel projectModel=new ProjectModel();
                        BeanUtils.copyProperties(p,projectModel);
                        projects.add(projectModel);
                    });
                }
                employeeModel.setProjects(projects);
                employees.add(employeeModel);
            });
        }
        return employees;
    }
    @Transactional
    public String updateResources(EmployeeModel employeeModel)
    {
        if(employeeRepository.existsByEmail(employeeModel.getEmail())) {
            Employee employee = employeeRepository.findByEmail(employeeModel.getEmail()).get(0);
            BeanUtils.copyProperties(employeeModel, employee);
            try {
                employeeRepository.save(employee);
                employeeModel.getProjects().stream().forEach(p -> {
                    try {
                        Project project = projectRepository.findProjectByEmail(employeeModel.getEmail()).get(0);
                        if (Objects.nonNull(project)) {
                            p.setEmail(employeeModel.getEmail());
                            BeanUtils.copyProperties(p, project);
                            try {
                                projectRepository.save(project);
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                });
            } catch (Exception e) {
                throw e;
            }

            return "Resource Updated";
        }
        else {return "Resource cant be updated";}
    }
    @Transactional
    public String deleteResource(EmployeeModel employeeModel){
        if (employeeRepository.existsByEmail(employeeModel.getEmail())){
            try {
                employeeRepository.deleteByEmail(employeeModel.getEmail());
                try {
                    projectRepository.deleteByEmail(employeeModel.getEmail());
                }catch (Exception e){
                    throw e;
                }
            }catch (Exception e){
                throw e;
            }
            return "Removed successfully!";
        }else {
            return "Resource does not exist.";
        }
    }
    public List<Employee> getEmployee(String email)
    {
        List<Employee> employeeList=new ArrayList<>();
       employeeList = employeeRepository.findByEmail(email);
        return employeeList;
    }
}




