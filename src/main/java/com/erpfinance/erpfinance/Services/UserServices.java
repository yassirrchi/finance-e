package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.DTOs.UserDTO;
import com.erpfinance.erpfinance.Requests.UserLogin;

public interface UserServices {
    public UserDTO login(UserLogin userLogin);

}
