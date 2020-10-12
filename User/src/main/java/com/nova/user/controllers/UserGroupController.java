package com.nova.user.controllers;

import com.nova.user.dtos.CustomerDTO;
import com.nova.user.dtos.UserDTO;
import com.nova.user.dtos.UserGroupDTO;
import com.nova.user.services.UserGroupService;
import com.nova.user.utils.UserConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = UserConstants.CONFIG_PATH_VERSION)
public class UserGroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGroupController.class);

    @Autowired
    private UserGroupService userGroupService;

    @PostMapping(UserConstants.USER_DEFAULT_GROUP_CREATION)
    public ResponseEntity<Boolean> createDefaultUserGroup (@RequestBody CustomerDTO customerDTO) {
        LOGGER.info("create user group method start");
        Boolean responseDto = userGroupService.createDefaultUserGroup(customerDTO);
        LOGGER.info("create user group method end");
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping(UserConstants.USER_GROUP_DETAILS)
    public ResponseEntity<UserGroupDTO> createUserGroup(@RequestBody UserGroupDTO userGroupDTO) {
        LOGGER.info("create user group method start");
        UserGroupDTO responseDto = userGroupService.createUserGroup(userGroupDTO);
        LOGGER.info("create user group method end");
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping(UserConstants.USER_GROUP_DETAILS)
    public ResponseEntity<UserGroupDTO> updateUserGroup(@RequestBody UserGroupDTO releaseDTO) {
        LOGGER.info("update release method start");
        UserGroupDTO responseDto = userGroupService.updateUserGroup(releaseDTO);
        LOGGER.info("update release method end");
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping(UserConstants.USER_GROUP_DETAILS + UserConstants.CUSTOMER_MAPPER_ID)
    public ResponseEntity<List<UserGroupDTO>> getUserGroupDetails(@PathVariable UUID customerMapperId) {
        LOGGER.info("get release method start");
        List<UserGroupDTO> responseDto = userGroupService.getUserGroupDetails(customerMapperId);
        LOGGER.info("get release method end");
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping(UserConstants.USER_GROUP_DETAILS + UserConstants.USER_GROUP_ID)
    public ResponseEntity<UserGroupDTO> getUserGroupDetailsById(@PathVariable Long userGroupId) {
        LOGGER.info("get by id release method start");
        UserGroupDTO responseDto = userGroupService.getUserGroupDetailsById(userGroupId);
        LOGGER.info("get by id release method end");
        return ResponseEntity.ok().body(responseDto);
    }
}
