package com.nova.user.dtos;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class RoleMapDTO {

    private Long roleMapId;

    private Long userId;

    private Long roleId;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
