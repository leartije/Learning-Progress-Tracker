package tracker.repository;

import tracker.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }
}
