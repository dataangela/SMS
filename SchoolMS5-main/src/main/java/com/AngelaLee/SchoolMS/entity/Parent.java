package com.AngelaLee.SchoolMS.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * model class for parent
 *
 * */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column=@Column(name="parent_name")
        ),
        @AttributeOverride(
                name="email",
                column=@Column(name="parent_email")
        ),
        @AttributeOverride(
                name="phoneNumber",
                column=@Column(name="parent_phoneNumber")
        )


})
public class Parent {
    private String name;
    private String email;
    private String phoneNumber;
}
