package com.AngelaLee.SchoolMS.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * login DTO
 * */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDTO {

    @Email
    private String login;

    @NotEmpty
    private String password;
}
