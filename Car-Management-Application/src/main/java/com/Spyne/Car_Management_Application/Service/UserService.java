package com.Spyne.Car_Management_Application.Service;

import com.Spyne.Car_Management_Application.CarContraints.CarContraints;
import com.Spyne.Car_Management_Application.CarUtilites.Carutilites;
import com.Spyne.Car_Management_Application.Model.User;
import com.Spyne.Car_Management_Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
     UserRepository userRepository;
    public ResponseEntity<String> signUp(Map<String, String> userMap) {
        if (validation(userMap)) {
            User user= userRepository.findByEmailId(userMap.get("email"));
            if(Objects.isNull(user)){
                //userRepository.save(getUserData(userMap));
                userRepository.save(getUserData(userMap));
                return Carutilites.getMessage("User created Successfully!",HttpStatus.OK);
            }
            else {
                return Carutilites.getMessage("User already exit",HttpStatus.OK);
            }
        } else {
            return Carutilites.getMessage(CarContraints.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }

    }


    private User getUserData(Map<String, String> userMap) {
        User user=new User();
        user.setFistName(userMap.get("fistName"));
        user.setLastName(userMap.get("lastName"));
        user.setEmail(userMap.get("email"));
        user.setState(userMap.get("state"));
        user.setPassword(userMap.get("password"));
        user.setPhoneNUmber(userMap.get("phoneNUmber"));
        user.setCountry(userMap.get("country"));
        return user;

    }

    private boolean validation (Map<String, String> userMap) {
        return userMap.containsKey("fistName") && userMap.containsKey("lastName") && userMap.containsKey("email") && userMap.containsKey("password") && userMap.containsKey("phoneNUmber") && userMap.containsKey("state") && userMap.containsKey("country");
    }

    public ResponseEntity<String> loginUser(Map<String, String> loginRequest) {
        if(validationLogin(loginRequest))
        {
            User user= userRepository.findByEmailId(loginRequest.get("email"));
            if(!Objects.isNull(user)) {
                if (user.getEmail().equals(loginRequest.get("email")) && user.getPassword().equals(loginRequest.get("password"))) {
                    return Carutilites.getMessage("User Login successfully!", HttpStatus.OK);
                } else {
                    return Carutilites.getMessage("Please Enter Correct email or password", HttpStatus.OK);
                }
            }
            else {
                return Carutilites.getMessage("User not exit!",HttpStatus.OK);
            }

        }else {
            return Carutilites.getMessage(CarContraints.INVALID_DATA, HttpStatus.BAD_REQUEST);

        }



    }

    private boolean validationLogin(Map<String, String> loginRequest) {
        return (loginRequest.containsKey("email") && loginRequest.containsKey("password"));
    }
}
