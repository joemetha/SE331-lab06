package camt.cbsd.dao;

import camt.cbsd.entity.Student;

import java.util.List;

/**
 * Created by JM on 3/28/2017.
 */
public interface StudentDao {
    List<Student> getStudents();
    Student findById(long id);
}
