package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Textbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface for textbook repository
 * */
@Repository
public interface TextbookRepository extends JpaRepository<Textbook,Long> {

}
