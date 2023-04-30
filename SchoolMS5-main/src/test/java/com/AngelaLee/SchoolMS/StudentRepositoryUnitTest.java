package com.AngelaLee.SchoolMS;

import com.AngelaLee.SchoolMS.entity.Student;
import com.AngelaLee.SchoolMS.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryUnitTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testAddNewStudent(){
        Student student = new Student();
        student.setFirstName("Vivian");
        student.setLastName("Washington");
        student.setEmailAddress("vivian@gmail.com");
        Student savedStudent = studentRepository.save(student);
        Assertions.assertNotEquals(savedStudent, null);
        Assertions.assertNotEquals(savedStudent.getStudentId(),1);
        Assertions.assertEquals(savedStudent.getFirstName(),"Vivian");

    }

    @Test
    public void testUpdateStudent(){
        Long studentId = Long.valueOf(4);
       Optional<Student> optionalStudent = studentRepository.findById(studentId);

       Student student = optionalStudent.get();
       student.setFirstName("Elle");
       studentRepository.save(student);

       Student updateStudent = studentRepository.findById(studentId).get();
       Assertions.assertEquals(updateStudent.getFirstName(),"Elle");

    }

    @Test
    public void testGetStudent(){
        Long studentId = Long.valueOf(2);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Assertions.assertNotNull(optionalStudent);
        System.out.println(optionalStudent);
    }
    @Test
    public void testDeleteStudent(){
        Long studentId = Long.valueOf(3);
        studentRepository.deleteById(studentId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Assertions.assertTrue(optionalStudent.isEmpty());
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("ellen@gmail.com");
        System.out.println("student: "+student);
    }

    @Test
    public void printfindByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("ellen","sanders");
        System.out.println("student: "+ student);
    }

    @Test
    public void printfindByFirstNameAndLastNameAndEmailAddress(){
        Student student = studentRepository.findByFirstNameAndLastNameAndEmailAddress("ellen","sanders","ellen@gmail.com");
        System.out.println("student: "+ student);
    }
}
