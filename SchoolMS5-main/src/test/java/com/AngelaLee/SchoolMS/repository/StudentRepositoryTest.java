package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Parent;
import com.AngelaLee.SchoolMS.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailAddress("ann@gmail.com")
                .firstName("ann")
                .lastName("baker")
                //.guardianName("bob")
                //.guardianEmail("bob@gmail.com")
                //.guardianMobile("5555555555")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithParent(){
        Parent parent=Parent.builder()
                .name("Alex")
                .email("alex@gmail.com")
                .phoneNumber("555-555-5555").build();
        Student student = Student.builder()
                .emailAddress("chris@gmail.com")
                .firstName("chris")
                .lastName("bush")
                .parent(parent)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList="+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("ann");
        System.out.println("Students: "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("an");
        System.out.println("Students: "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByParentName("bob");
        System.out.println("students: "+students);
    }

}