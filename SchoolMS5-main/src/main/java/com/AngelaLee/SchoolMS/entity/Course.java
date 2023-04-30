package com.AngelaLee.SchoolMS.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * model class for course
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String subject;
    private Integer credit;

    @OneToOne(mappedBy="course",cascade = CascadeType.ALL)
    private Textbook textbook;

  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name="instructor_id",
            referencedColumnName = "instructorId"
    )
    private Instructor instructor;

  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(
                    name="course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public Course(Long valueOf, String functional_programming, int i) {
    }

    //need refactor
    public void addStudents(Student student){
        if(students==null){
            students=new ArrayList<>();
            students.add(student);
        }
    }
}
