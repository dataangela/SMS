package com.AngelaLee.SchoolMS.service.UserService;

import com.AngelaLee.SchoolMS.dto.UserDTO;
import com.AngelaLee.SchoolMS.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String userName);
    public void create(UserDTO userDTO);
    public User findUserByEmail(String email);
    public User findUserByName(String name);
}
