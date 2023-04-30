package com.AngelaLee.SchoolMS.service.CourseService;

import com.AngelaLee.SchoolMS.entity.Course;


import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);

    public void printCourse() ;
    public void saveCourseWithTeacher() ;

    public void saveCourseWithStudentAndTeacher() ;
}
