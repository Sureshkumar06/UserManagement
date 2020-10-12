package com.nova.user.dtos;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.UUID;

@Data
public class UserGroupDTO {

    private Long userGroupId;

    private UUID customerMapperId;

    private String userGroupName;

    private Long rootGroupId;

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
