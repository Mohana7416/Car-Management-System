package com.Spyne.Car_Management_Application.Service;

import com.Spyne.Car_Management_Application.Model.User;
import com.Spyne.Car_Management_Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class CustomerUserDetailsService implements UserDetailsService {


  private  UserRepository userRepository;

    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=UserRepository.findByEmailId1(email);
        if(Objects.isNull(user))
        {
            System.out.println("User not Available");
        }
        return new CustomeUserDetails(user);
    }
}