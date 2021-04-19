package main;

import main.bean.Human;
import main.bean.Student;
import main.service.HumanService;
import main.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumanServiceTest {

    @Test
    public void getHumanTest() {
        HumanService humanService = new HumanService();
        StudentService studentService = new StudentService();

        Human human = humanService.getHuman("taro", 10);
        Student student = studentService.getStudent("taro", 10);

        Assertions.assertEquals(human.getHumanAge(), student.getAge());
        Assertions.assertNotEquals(human.getHumanName(), student.getName());
        Assertions.assertEquals(human.getHumanName() + "さん", student.getName());
    }
}
