package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_role")
@ApiModel(value="SsoRole对象", description="角色表")
public class SsoRole extends Model<SsoRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一关联键")
    private String roleCode;

    @ApiModelProperty(value = "角色表")
    private String roleName;

    @ApiModelProperty(value = "是否删除")
    private Integer status;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "修改人")
    private String updateDy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateDate;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public String getUpdateDy() {
        return updateDy;
    }

    public void setUpdateDy(String updateDy) {
        this.updateDy = updateDy;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleCode;
    }

    @Override
    public String toString() {
        return "SsoRole{" +
            "roleCode=" + roleCode +
            ", roleName=" + roleName +
            ", status=" + status +
            ", description=" + description +
            ", createBy=" + createBy +
            ", createDate=" + createDate +
            ", updateDy=" + updateDy +
            ", updateDate=" + updateDate +
        "}";
    }
}
