package com.nova.user.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_map")
@DynamicUpdate(value = true)
@Data
public class RoleMap extends RecordInfo implements Serializable {

    private static final long serialVersionId =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_map_id",columnDefinition = "uniqueidentifier")
    private Long roleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleMaster roleMaster;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserMaster userMaster;

}
