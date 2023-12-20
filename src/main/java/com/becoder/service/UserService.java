package com.becoder.service;

import com.becoder.model.UserDtls;

public interface UserService {

    UserDtls createUser(UserDtls user);

    boolean checkEmail(String email);

    // Add additional methods if needed

    UserDtls findByEmail(String email);
}
