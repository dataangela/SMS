package com.AngelaLee.SchoolMS.repository;


import com.AngelaLee.SchoolMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface for user repository
 *
 * */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);
    public User findUserByUserName(String name);
}
