//package com.nova.user.services.impl;
//
//import com.nova.user.dtos.UserMasterDto;
//import com.nova.user.entities.UserMasterEntity;
//import com.nova.user.exception.ResourceExist;
//import com.nova.user.exception.ResourceNotFound;
//import com.nova.user.mappers.UserMasterMapper;
//import com.nova.user.repositories.UserMasterRepository;
//import com.nova.user.services.UserMasterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class UserMasterServiceImpl implements UserMasterService {
//
//    @Autowired
//    UserMasterRepository userMasterRepository;
//
//
//    @Override
//    public UserMasterDto addUser(UserMasterDto userMasterDto) throws ResourceExist {
//        UserMasterEntity entity = userMasterRepository.getUserByName(userMasterDto.getName());
//        if (entity != null) {
//            throw new ResourceExist("User name exist");
//        }
//        entity = UserMasterMapper.INSTANCE.toEntity(userMasterDto);
//        entity = userMasterRepository.save(entity);
//
//        return UserMasterMapper.INSTANCE.toDto(entity);
//    }
//
//    @Override
//    public UserMasterDto getUserByName(String name) throws ResourceNotFound {
//        return Optional.ofNullable(userMasterRepository
//                .getUserByName(name))
//                .map(UserMasterMapper.INSTANCE::toDto)
//                .orElseThrow(() -> new ResourceNotFound("User not found"));
//    }
//
//    @Override
//    public List<UserMasterDto> getUsers() {
//        return Optional.ofNullable(userMasterRepository.findAll())
//                .orElse(Collections.emptyList())
//                .stream()
//                .map(UserMasterMapper.INSTANCE::toDto)
//                .collect(Collectors.toList());
//    }
//}
