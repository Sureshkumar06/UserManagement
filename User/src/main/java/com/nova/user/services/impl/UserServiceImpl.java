package com.nova.user.services.impl;

import com.nova.user.dtos.UserDTO;
import com.nova.user.entities.UserMaster;
import com.nova.user.repositories.UserMasterRepository;
import com.nova.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if(userDTO !=null){
            UserMaster userMaster = new UserMaster();
//            userMaster.setDeviceMaster();
//            userMaster.setUserGroup();
        }
        return null;
    }
}
