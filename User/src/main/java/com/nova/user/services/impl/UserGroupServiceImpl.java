package com.nova.user.services.impl;

import com.nova.user.dtos.CustomerDTO;
import com.nova.user.dtos.UserGroupDTO;
import com.nova.user.entities.UserGroup;
import com.nova.user.mappers.UserGroupMapper;
import com.nova.user.repositories.UserGroupRepository;
import com.nova.user.services.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGroupServiceImpl.class);

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public Boolean createDefaultUserGroup(CustomerDTO customerDTO) {
        LOGGER.info("create default user group service method start");
        Boolean status = false;
        UserGroup userGroup = new UserGroup();
        if(customerDTO.getCustomerMapperId() !=null) {
            userGroup.setUserGroupName("Default");
            userGroup.setCustomerMapperId(customerDTO.getCustomerMapperId());
            userGroup.setRootGroupId(null);
            userGroup.setActive("Y");
            userGroup.setCreatedAt(new Date());
            userGroup.setCreatedBy("Admin");
            userGroup.setUpdatedAt(new Date());
            userGroup.setUpdatedBy("Admin");
            userGroup.setVersion("V1.0");
            userGroup.setRecVerNo(1);
            UserGroup userGroup1 = userGroupRepository.save(userGroup);
            if(userGroup1 !=null){
                status = true;
            }
        }
        LOGGER.info("create default user group service method end");
        return status;
    }

    @Override
    public UserGroupDTO createUserGroup(UserGroupDTO userGroupDTO) {
        if(userGroupNameUniqueCheck(userGroupDTO)){
            UserGroup userGroup = new UserGroup();
            userGroup.setUserGroupName(userGroupDTO.getUserGroupName());
            userGroup.setCustomerMapperId(userGroupDTO.getCustomerMapperId());
            userGroup.setRootGroupId(userGroupDTO.getRootGroupId() !=null ? userGroupDTO.getRootGroupId() : null);

            userGroup.setActive("Y");
            userGroup.setCreatedAt(new Date());
            userGroup.setCreatedBy("Admin");
            userGroup.setUpdatedAt(new Date());
            userGroup.setUpdatedBy("Admin");
            userGroup.setVersion("V1.0");
            userGroup.setRecVerNo(1);
            UserGroup userGroup1 = userGroupRepository.save(userGroup);
            userGroupDTO = UserGroupMapper.INSTANCE.toDto(userGroup1);

        }else{
            LOGGER.info("user group name duplicate in create");
            userGroupDTO.setErrorStatus(true);
            userGroupDTO.setErrorMessage("User Group Name is already available");
        }
        LOGGER.info("create user group service method end");
        return userGroupDTO;
    }

    private boolean userGroupNameUniqueCheck(UserGroupDTO userGroupDTO){
        LOGGER.info("user group name unique check method start");
        boolean uniqueCheck = false;
        if(userGroupRepository.findByCustomerMapperIdAndUserGroupName(userGroupDTO.getCustomerMapperId(),userGroupDTO.getUserGroupName()).isPresent()){
            uniqueCheck = false;
        } else {
            uniqueCheck = true;
        }
        LOGGER.info("user group name unique check method end");
        return uniqueCheck;
    }

    @Override
    public UserGroupDTO updateUserGroup(UserGroupDTO userGroupDTO) {
        LOGGER.info("update user group service method start");
        UserGroupDTO userGroupDTORes = new UserGroupDTO();
        if(userGroupNameUniqueCheckWithId(userGroupDTO)) {
            if(userGroupDTO.getUserGroupId() !=null){
                Optional<UserGroup> userGroupOptional = userGroupRepository.findById(userGroupDTO.getUserGroupId());
                UserGroup userGroup = null;
                if (userGroupOptional.isPresent()) {
                    userGroup = userGroupOptional.get();
                } else {
                    LOGGER.info("user group data not available in update");
                    userGroupDTORes.setUserGroupId(userGroupDTO.getUserGroupId());
                    userGroupDTORes.setErrorStatus(true);
                    userGroupDTORes.setErrorMessage("Data Not Available");
                    return userGroupDTORes;
                }
                userGroup = UserGroupMapper.INSTANCE.toEntity(userGroupDTO);
                if (userGroupRepository.save(userGroup) != null) {
                    userGroupDTORes = getUserGroupDetailsById(userGroupDTO.getUserGroupId());
                }
            }
        }else{
            LOGGER.info("user group name duplicate in update");
            userGroupDTORes.setErrorStatus(true);
            userGroupDTORes.setErrorMessage("Group Name is already available");
        }
        LOGGER.info("update user group service method end");
        return userGroupDTORes;
    }

    private boolean userGroupNameUniqueCheckWithId(UserGroupDTO userGroupDTO){
        LOGGER.info("user group name unique check with id method start");
        boolean uniqueCheck = false;
        List<Long> ids = new ArrayList<>();
        ids.add(userGroupDTO.getUserGroupId());
        if(userGroupRepository.findByCustomerMapperIdAndUserGroupNameAndUserGroupIdNotIn(userGroupDTO.getCustomerMapperId(),userGroupDTO.getUserGroupName(),ids).isPresent()){
            uniqueCheck = false;
        } else {
            uniqueCheck = true;
        }
        LOGGER.info("user group name unique check with id method end");
        return uniqueCheck;
    }

    @Override
    public List<UserGroupDTO> getUserGroupDetails(UUID customerMapperId) {
        List<UserGroupDTO> userGroupDTOList = new ArrayList<>();
        List<UserGroup> userGroupList = userGroupRepository.findByCustomerMapperId(customerMapperId);
        if(userGroupList !=null && !userGroupList.isEmpty()){
            userGroupList.stream().map(group ->{
                UserGroupDTO userGroupDTO = new UserGroupDTO();
                userGroupDTO = UserGroupMapper.INSTANCE.toDto(group);
                userGroupDTOList.add(userGroupDTO);
                return null;
            }).collect(Collectors.toList());
        }
        return userGroupDTOList;
    }

    @Override
    public UserGroupDTO getUserGroupDetailsById(Long userGroupId) {
        LOGGER.info("get user group details by id service method start");
        UserGroupDTO userGroupDTO = new UserGroupDTO();
        if(userGroupId !=null){
            Optional<UserGroup> userGroup = userGroupRepository.findByUserGroupId(userGroupId);
            if(userGroup.isPresent()){
                userGroupDTO = UserGroupMapper.INSTANCE.toDto(userGroup.get());
            }
        }else{
            LOGGER.info("invalid id for getUserGroupDetailsById");
            userGroupDTO.setErrorMessage("Give Valid Id");
            userGroupDTO.setErrorStatus(true);
        }
        LOGGER.info("get user group details by id service method end");
        return userGroupDTO;
    }
}
