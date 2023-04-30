package com.AngelaLee.SchoolMS.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * model class for student
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="table_student",
        uniqueConstraints = @UniqueConstraint(
                name="emailAddress_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name="email_address",
            nullable = false
    )
    private String emailAddress;
    @Embedded
    private Parent parent;
    @ManyToMany(cascade=CascadeType.ALL,mappedBy="students")
    private List<Course> courses;
}
