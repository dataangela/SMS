package com.AngelaLee.SchoolMS.service.InstructorService;

import com.AngelaLee.SchoolMS.entity.Course;
import com.AngelaLee.SchoolMS.entity.Instructor;
import com.AngelaLee.SchoolMS.exceptions.EntityNotFoundException;
import com.AngelaLee.SchoolMS.repository.InstructorRepository;
import com.AngelaLee.SchoolMS.service.CourseService.CourseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    private static final Logger logger = LogManager.getLogger(CourseServiceImpl.class);

    public List<Instructor> getAllInstructor(){
        try{
            return instructorRepository.findAll();
        }catch (DataAccessException ex) {

            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Instructor saveInstructor(Instructor instructor){
        try{
            return instructorRepository.save(instructor);
        }catch(DataAccessException ex){
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Instructor getInstructorById(Long id){
        try {
            return instructorRepository.findById(id).get();
        } catch (EntityNotFoundException ex) {
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public Instructor updateInstructor(Instructor instructor){
        try{
            return instructorRepository.save(instructor);
        }catch (DataAccessException ex){

            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    public void deleteInstructorById(Long id){
        try{
            instructorRepository.deleteById(id);
        }catch (EntityNotFoundException ex) {
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }
}
