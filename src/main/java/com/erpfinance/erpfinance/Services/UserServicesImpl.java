package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.DTOs.UserDTO;
import com.erpfinance.erpfinance.Entities.UserAndRoles.User;
import com.erpfinance.erpfinance.Repositories.UserRepository;
import com.erpfinance.erpfinance.Requests.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO login(UserLogin userLogin) {

       User user= userRepository.findByUsername("yassir");

        User utilisateur=userRepository.findByUsername(userLogin.getUsername());
        //System.out.println("shit is not null wtf "+utilisateur.getPassword()+" "+utilisateur.getUsername());


        if(utilisateur==null){
            System.out.println("user doesnt exist");

            return null;
        }

        else{
            if(!utilisateur.getPassword().equals(userLogin.getPassword()))
                return null;
            System.out.println("user  exist");
            return UserDTO.builder().username(utilisateur.getUsername()).id(utilisateur.getId()).build();
        }









    }
}
