package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * interface for courserepository
 * */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
