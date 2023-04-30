package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface for student repository
 *
 * */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //need refactor here
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String str);

    List<Student> findByLastNameNotNull();

    List<Student> findByParentName(String parentName);

    @Query(value="select * from table_student where first_name=:firstName and last_name=:lastName", nativeQuery = true)
    Student findByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query(value="select * from table_student where email_address=:emailAddress", nativeQuery = true)
    Student getStudentByEmailAddress(String emailAddress);

    @Query(value="select * from table_student where first_name=:firstName and last_name=:lastName and email_address=:emailAddress", nativeQuery = true)
    Student findByFirstNameAndLastNameAndEmailAddress(String firstName,String lastName,String emailAddress);

}
