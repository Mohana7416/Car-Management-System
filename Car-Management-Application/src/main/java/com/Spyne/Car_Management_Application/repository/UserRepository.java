package com.Spyne.Car_Management_Application.repository;

import com.Spyne.Car_Management_Application.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    static User findByEmailId1(String email) {
    }

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    public User findByEmailId(@Param("email") String email);

}
