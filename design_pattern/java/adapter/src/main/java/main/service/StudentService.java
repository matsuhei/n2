package main.service;

import main.adapter.HumanAdapter;
import main.bean.Student;

public class StudentService {

    public Student getStudent(String name, Integer age) {
        return new HumanAdapter(name, age);
    }
}
