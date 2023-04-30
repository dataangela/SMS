package com.AngelaLee.SchoolMS.repository;

import com.AngelaLee.SchoolMS.entity.Course;
import com.AngelaLee.SchoolMS.entity.Textbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TextbookRepositoryTest {
    @Autowired
    private TextbookRepository textbookRepository;
    Course course = Course.builder().subject("Python").credit(4).build();
    @Test
    public void saveCourseMaterial(){
        Textbook textbook = Textbook.builder().isbnNumber("Python.com").course(course).build();
        textbookRepository.save(textbook);
    }

    @Test
    public void printAllCourseMaterials(){
        List<Textbook> courseMaterialList = textbookRepository.findAll();
        System.out.println("CourseMaterials: "+courseMaterialList);
    }

}