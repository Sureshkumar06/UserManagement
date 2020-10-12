package com.nova.user.services;

import com.nova.user.dtos.CustomerDTO;
import com.nova.user.dtos.UserGroupDTO;

import java.util.List;
import java.util.UUID;

public interface UserGroupService {

    Boolean createDefaultUserGroup(CustomerDTO customerDTO);
    
    UserGroupDTO createUserGroup(UserGroupDTO userGroupDTO);

    UserGroupDTO updateUserGroup(UserGroupDTO userGroupDTO);

    List<UserGroupDTO> getUserGroupDetails(UUID customerMapperId);

    UserGroupDTO getUserGroupDetailsById(Long userGroupId);
}
