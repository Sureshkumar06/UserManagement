package com.nova.user.dtos;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Data
public class UserDTO {

    private Long userId;

    private Long deviceMasterId;

    private Long userGroupId;

    private String userName;

    private String loginName;

    private String password;

    private String emailId;

    private String active;

    private String version;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private String errorMessage;

    private boolean errorStatus;

    private Integer recVerNo;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
