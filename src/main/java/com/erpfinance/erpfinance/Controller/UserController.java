package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.DTOs.UserDTO;
import com.erpfinance.erpfinance.Entities.UserAndRoles.User;
import com.erpfinance.erpfinance.Requests.UserLogin;
import com.erpfinance.erpfinance.Services.UserServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserLogin userLogin){
       System.out.println(userLogin.getUsername()+" "+userLogin.getPassword());
        UserDTO userDTO=userServices.login(userLogin);
        if(userDTO==null){
            System.out.println("wrong pwd");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

        else{
            return new ResponseEntity<>(userDTO, HttpStatus.resolve(200));
        }






    }
}
