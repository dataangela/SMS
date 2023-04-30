package com.AngelaLee.SchoolMS.controller;
import com.AngelaLee.SchoolMS.entity.Instructor;
import com.AngelaLee.SchoolMS.service.InstructorService.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * controller for instructor
 * */
@Controller
public class InstructorController {
    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public String listInstructors(Model model){
        model.addAttribute("instructor",instructorService.getAllInstructor());
        return "instructors";
    }

    @GetMapping("/instructors/new")
    public String createInstructorForm(Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("instructor",instructor);
        return "create_instructor";

    }

    @PostMapping("/instructors")
    public String saveInstructor(@ModelAttribute("instructor")Instructor instructor){
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }

    @GetMapping("/instructors/edit/{id}")
    public String editInstructorForm(@PathVariable Long id, Model model) throws InstructorController.InstructorNotFoundException {
        model.addAttribute("instructor",instructorService.getInstructorById(id));
        return "edit_instructor";

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class InstructorNotFoundException extends Exception {

        public InstructorNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @PostMapping("/instructors/{id}")
    public String updateInstructor(@PathVariable Long id,
                               @ModelAttribute("instructor") Instructor instructor,
                               Model model){
        try{
            Instructor existingInstructor = instructorService.getInstructorById(id);
            existingInstructor.setInstructorId(id);
            existingInstructor.setFirstName(instructor.getFirstName());
            existingInstructor.setLastName(instructor.getLastName());
            instructorService.updateInstructor( existingInstructor);
        }catch(IllegalArgumentException e){
            System.out.println("Exception occurred, instructor not updated");
            throw e;
        }

        return "redirect:/instructors";
    }
    @GetMapping("/instructors/{id}")
    public String deleteInstructor(@PathVariable Long id){
        try{
            instructorService.deleteInstructorById(id);
        }catch(IllegalArgumentException ex){
            System.out.println("Exception occurred, instructor not deleted");
            throw ex;
        }

        return "redirect:/instructors";
    }
}
