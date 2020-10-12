package com.nova.user.repositories;

import com.nova.user.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {

    Optional<UserGroup> findByCustomerMapperIdAndUserGroupName(UUID customerMapperId, String userGroupName);

    Optional<UserGroup> findByCustomerMapperIdAndUserGroupNameAndUserGroupIdNotIn(UUID customerMapperId, String userGroupName, List<Long> ids);

    List<UserGroup> findByCustomerMapperId(UUID customerMapperId);

    Optional<UserGroup> findByUserGroupId(Long userGroupId);
}
