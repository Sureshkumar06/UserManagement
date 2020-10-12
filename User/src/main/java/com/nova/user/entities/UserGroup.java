package com.nova.user.entities;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_group")
@DynamicUpdate(value = true)
@Data
public class UserGroup extends RecordInfo implements Serializable {

    private static final long serialVersionId =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_group_id",columnDefinition = "uniqueidentifier")
    private Long userGroupId;

    @Column(name = "customer_mapper_id")
    @Type(type="uuid-char")
    private UUID customerMapperId;

    @Column(name = "user_group_name")
    private String userGroupName;

    @Column(name = "root_group_id")
    private Long rootGroupId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userGroup",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<UserMaster> userMasterList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {

        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this);
    }
}
