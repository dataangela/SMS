package com.AngelaLee.SchoolMS.service.CourseService;

import com.AngelaLee.SchoolMS.entity.Course;
import com.AngelaLee.SchoolMS.entity.Instructor;
import com.AngelaLee.SchoolMS.entity.Student;
import com.AngelaLee.SchoolMS.exceptions.EntityNotFoundException;
import com.AngelaLee.SchoolMS.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
@Service

public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    private static final Logger logger = LogManager.getLogger(CourseServiceImpl.class);

    public List<Course> getAllCourses(){
        try{
            logger.info("getting all course");
            return courseRepository.findAll();
        }catch (DataAccessException ex) {
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Course saveCourse(Course course){
        try{
            return courseRepository.save(course);
        }catch(DataAccessException ex){
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Course getCourseById(Long id){
        try {
            return courseRepository.findById(id).get();
        } catch (EntityNotFoundException ex) {
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Course updateCourse(Course course){
        try{
            return courseRepository.save(course);
        }catch (DataAccessException ex){
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public void deleteCourseById(Long id){
        try{
            courseRepository.deleteById(id);
        }catch (EntityNotFoundException ex) {
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }


    public void printCourse() {
        List<Course> courseList =
                courseRepository.findAll();
        System.out.println("Courses: " + courseList);
    }
    public void saveCourseWithTeacher() {

        Instructor instructor = Instructor.builder().firstName("Henry").lastName("Wilkins").build();
        Course course = Course.builder().credit(6).subject("Intro to dynamic programming").build();
        courseRepository.save(course);
    }

    public void saveCourseWithStudentAndTeacher() {
        Instructor instructor = Instructor.builder().lastName("Zacker").firstName("John").build();
        Student student = Student.builder().firstName("Alex").lastName("Johnson").emailAddress("alex@gmail.com").build();
        Course course = Course.builder().subject("Functional Programming").credit(3).instructor(instructor).build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}