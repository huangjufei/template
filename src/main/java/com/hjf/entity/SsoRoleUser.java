package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 中间表 角色和用户,(角色和用户是多对多的的关系)
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_role_user")
@ApiModel(value="SsoRoleUser对象", description="中间表 角色和用户,(角色和用户是多对多的的关系)")
public class SsoRoleUser extends Model<SsoRoleUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户code")
    private String userCode;

    @ApiModelProperty(value = "角色表的code")
    private String roleCode;

    @ApiModelProperty(value = "是否删除 1已删除,0未删除")
    private Integer status;

    @ApiModelProperty(value = "描述")
    private String description;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

    @Override
    protected Serializable pkVal() {
        return this.userCode;
    }

    @Override
    public String toString() {
        return "SsoRoleUser{" +
            "userCode=" + userCode +
            ", roleCode=" + roleCode +
            ", status=" + status +
            ", description=" + description +
        "}";
    }
}
