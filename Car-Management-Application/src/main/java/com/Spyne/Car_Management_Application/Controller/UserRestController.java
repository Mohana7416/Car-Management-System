package com.Spyne.Car_Management_Application.Controller;

import com.Spyne.Car_Management_Application.CarContraints.CarContraints;
import com.Spyne.Car_Management_Application.CarUtilites.Carutilites;
import com.Spyne.Car_Management_Application.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String demo()
    {
        return "hi";
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String,String> loginRequest) {
        return userService.loginUser(loginRequest);
    }
    @PostMapping("/signUp")
    public ResponseEntity<String> signup(@RequestBody Map<String,String> UserMap)
    {
        try{
            return userService.signUp(UserMap);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return Carutilites.getMessage(CarContraints.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
