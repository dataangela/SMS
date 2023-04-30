package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Course;
import com.AngelaLee.SchoolMS.entity.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstructorRepositoryTest {
    @Autowired
    private InstructorRepository teacherRepository;
    Course course1 = Course.builder().subject("DSA").credit(3).build();
    Course course2 = Course.builder().subject("C++").credit(3).build();
    @Test
    public void saveTeach(){
        Instructor instructor = Instructor.builder().firstName("John").lastName("Willams").build();
        teacherRepository.save(instructor);
    }
}