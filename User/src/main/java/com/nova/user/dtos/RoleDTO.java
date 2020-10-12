package com.nova.user.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class RoleDTO {

    private Long roleMapId;

    private String roleName;

    private String active;

    private String version;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private String errorMessage;

    private boolean errorStatus;

    private Integer recVerNo;
}
