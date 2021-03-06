package com.jasonli.auth.entity;

import com.jasonli.apicore.entity.RootEntity;
import com.jasonli.auth.enums.ActiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 操作权限
 *
 * @author JasonLi
 * @date 2019/3/1 19:32
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_permission")
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends RootEntity {
    @Column(columnDefinition = "varchar(120) comment '权限'")
    private String permission;

    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

    /**
     * 状态
     */
    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
