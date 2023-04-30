package com.AngelaLee.SchoolMS.service.StudentService;

import com.AngelaLee.SchoolMS.entity.Parent;
import com.AngelaLee.SchoolMS.entity.Student;
import com.AngelaLee.SchoolMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        try{
            return studentRepository.findAll();
        }catch(DataAccessException ex){
            logger.error("An exception occurred",ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Student saveStudent(Student student) {

        try{
            return studentRepository.save(student);
        }catch(DataAccessException ex){
            logger.error("An exception occurred", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Student getStudentById(Long id) {

        try{
            return studentRepository.findById(id).get();
        }catch(DataAccessException e){
            logger.error("An exception occurred, can't get the student",e.getMessage());
            throw e;
        }
    }

    @Override
    public Student updateStudent(Student student) {

        try {
            return studentRepository.save(student);
        } catch (DataAccessException e) {
            logger.error("An exception occurred: ",e.getMessage());
            throw e;
        }
    }


    @Override
    public void deleteStudentById(Long id) {

        try{
            studentRepository.deleteById(id);
        }catch(EntityNotFoundException e){
            logger.error("An exception occurred",e.getMessage());
            throw e;
        }
    }


    @Override
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

    @Override
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

    @Override
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList="+studentList);
    }

    @Override
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("ann");
        System.out.println("Students: "+ students);
    }

    @Override
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("an");
        System.out.println("Students: "+ students);
    }

    @Override
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByParentName("bob");
        System.out.println("students: "+students);
    }
}

