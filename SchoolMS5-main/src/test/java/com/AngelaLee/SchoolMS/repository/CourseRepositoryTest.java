package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Course;
import com.AngelaLee.SchoolMS.entity.Instructor;
import com.AngelaLee.SchoolMS.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courseList =
                courseRepository.findAll();
        System.out.println("Courses: "+ courseList);
    }

    @Test
    public void saveCourseWithTeacher(){

        Instructor instructor= Instructor.builder().firstName("Henry").lastName("Wilkins").build();
        Course course = Course.builder().credit(6).subject("Intro to dynamic programming").build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Instructor instructor = Instructor.builder().lastName("Zacker").firstName("John").build();
        Student student = Student.builder().firstName("Alex").lastName("Johnson").emailAddress("alex@gmail.com").build();
        Course course = Course.builder().subject("Functional Programming").credit(3).instructor(instructor).build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}