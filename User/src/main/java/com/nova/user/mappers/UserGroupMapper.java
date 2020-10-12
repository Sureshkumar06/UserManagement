package com.nova.user.mappers;

import com.nova.user.dtos.UserGroupDTO;
import com.nova.user.entities.UserGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserGroupMapper {
    UserGroupMapper INSTANCE = Mappers.getMapper(UserGroupMapper.class);

    UserGroup toEntity(UserGroupDTO userGroupDTO);
    UserGroupDTO toDto(UserGroup userGroup);
}
