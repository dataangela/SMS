package com.AngelaLee.SchoolMS.service.InstructorService;

import com.AngelaLee.SchoolMS.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor();

    Instructor saveInstructor(Instructor instructor);

    Instructor getInstructorById(Long id);

    Instructor updateInstructor(Instructor instructor);

    void deleteInstructorById(Long id);

}
