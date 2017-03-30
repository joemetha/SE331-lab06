package camt.cbsd.dao;

import camt.cbsd.entity.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JM on 3/28/2017.
 */
@Profile("secondDataSource")
@ConfigurationProperties(prefix = "server")
@Repository
public class SecondStudentDaoImpl implements StudentDao{

    List<Student> students;
    String baseUrl;
    String imageUrl;

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl=baseUrl;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl=imageUrl;
    }
    String imageBaseUrl;
    @PostConstruct
    private void init() {
        students = new ArrayList<>();

        Student student = new Student(1,"SE-000","Chartchai","D",
                5.00,imageBaseUrl+"temp.gif",true,0,
                "The Special One");
        students.add(student);
    }

    @Override
    public List<Student> getStudents(){
        return students;
    }

    @Override
    public Student findById(long id){
        return students.stream().filter(s -> s.getId() ==id).findFirst().get();
    }
}