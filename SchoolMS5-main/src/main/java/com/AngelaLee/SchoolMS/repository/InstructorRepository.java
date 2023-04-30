package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface for instructor repository
 * */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {

}
