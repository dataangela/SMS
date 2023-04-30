package com.AngelaLee.SchoolMS;

import com.AngelaLee.SchoolMS.entity.Course;

import com.AngelaLee.SchoolMS.repository.CourseRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CourseRepositoryUnitTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testAddNewCourse(){
        Course course = new Course();
        course.setSubject("Bash");
        course.setCredit(4);
        Course savedCourse = courseRepository.save(course);
        Assertions.assertNotEquals(savedCourse, null);
        Assertions.assertNotEquals(savedCourse.getCourseId(),1);
        Assertions.assertEquals(savedCourse.getSubject(),"Bash");

    }

    @Test
    public void testUpdateCourse(){
        Long courseId = Long.valueOf(2);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        Course course = optionalCourse.get();
        course.setSubject("C++");
        courseRepository.save(course);

        Course updateCourse = courseRepository.findById(courseId ).get();
        Assertions.assertEquals(updateCourse.getSubject(),"C++");

    }

    @Test
    public void testGetCourse(){
        Long courseId = Long.valueOf(2);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Assertions.assertNotNull(optionalCourse);
        System.out.println(optionalCourse);
    }
    @Test
    public void testDeleteCourse(){
        Long courseId = Long.valueOf(3);
        courseRepository.deleteById(courseId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Assertions.assertTrue(optionalCourse.isEmpty());
    }
}
