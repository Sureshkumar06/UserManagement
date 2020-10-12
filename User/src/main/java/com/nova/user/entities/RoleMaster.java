package com.nova.user.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_master")
@DynamicUpdate(value = true)
@Data
public class RoleMaster extends RecordInfo implements Serializable {

    private static final long serialVersionId =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id",columnDefinition = "uniqueidentifier")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

}
