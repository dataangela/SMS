package com.AngelaLee.SchoolMS.controller;

import com.AngelaLee.SchoolMS.entity.Course;

import com.AngelaLee.SchoolMS.service.CourseService.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

/**
 *
 * controller for course
 */

@Controller
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String listCourses(Model model){
        model.addAttribute("courses",courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "create_course";

    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course")Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) throws CourseNotFoundException{
        model.addAttribute("course",courseService.getCourseById(id));
        return "edit_course";

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class CourseNotFoundException extends Exception {

        public CourseNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable Long id,
                                @ModelAttribute("course") Course course,
                                Model model){
        try{
            Course existingCourse = courseService.getCourseById(id);
            existingCourse.setCourseId(id);
            existingCourse.setSubject(course.getSubject());
            existingCourse.setCredit(course.getCredit());
            courseService.updateCourse(existingCourse);
        }catch(IllegalArgumentException e){
            System.out.println("Exception occurred, course not updated");
            throw e;
        }

        return "redirect:/courses";
    }
    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id){
        try{
            courseService.deleteCourseById(id);
        }catch(IllegalArgumentException ex){
            System.out.println("Exception occurred, course not deleted");
            throw ex;
        }

        return "redirect:/courses";
    }

}

