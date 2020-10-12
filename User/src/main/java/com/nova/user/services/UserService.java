package com.nova.user.services;

import com.nova.user.dtos.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
}
