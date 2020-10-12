package com.nova.user.controllers;

import com.nova.user.dtos.UserDTO;
import com.nova.user.services.UserService;
import com.nova.user.utils.UserConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = UserConstants.CONFIG_PATH_VERSION)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(UserConstants.USER_DETAILS)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("create user method start");
        UserDTO responseDto = userService.createUser(userDTO);
        LOGGER.info("create user method end");
        return ResponseEntity.ok().body(responseDto);
    }

//    @PutMapping(MoMConstants.RELEASE_DETAILS)
//    public ResponseEntity<ReleaseDTO> updateRelease(@RequestBody ReleaseDTO releaseDTO) {
//        LOGGER.info("update release method start");
//        ReleaseDTO responseDto = releaseService.updateRelease(releaseDTO);
//        LOGGER.info("update release method end");
//        return ResponseEntity.ok().body(responseDto);
//    }
//
//    @GetMapping(MoMConstants.RELEASE_DETAILS)
//    public ResponseEntity<List<ReleaseDTO>> getReleaseDetails() {
//        LOGGER.info("get release method start");
//        List<ReleaseDTO> responseDto = releaseService.getReleaseDetails();
//        LOGGER.info("get release method end");
//        return ResponseEntity.ok().body(responseDto);
//    }
//
//    @GetMapping(MoMConstants.RELEASE_DETAILS + MoMConstants.RELEASE_ID)
//    public ResponseEntity<ReleaseDTO> getReleaseDetailsById(@PathVariable Long releaseId) {
//        LOGGER.info("get by id release method start");
//        ReleaseDTO responseDto = releaseService.getReleaseDetailsById(releaseId);
//        LOGGER.info("get by id release method end");
//        return ResponseEntity.ok().body(responseDto);
//    }
}
