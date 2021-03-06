package camt.cbsd.dao;

import camt.cbsd.entity.Student;

import java.util.List;

/**
 * Created by JM on 3/30/2017.
 */
public abstract class AbstractStudentDao implements StudentDao{
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

    @Override
    public List<Student> getStudents(){
        return students;
    }

    @Override
    public Student findById(long id){
        return students.stream().filter(s -> s.getId() ==id).findFirst().get();
    }
}
