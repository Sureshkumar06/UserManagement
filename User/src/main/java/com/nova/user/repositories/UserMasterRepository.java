package com.nova.user.repositories;

import com.nova.user.entities.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster,Long> {

//    @Query(value = "select * from user_master where id =:inpId",nativeQuery = true)
//    UserMasterEntity getUserById(@Param("inpId") Long id);
//    UserMasterEntity getUserByName(String name);
}
