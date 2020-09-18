package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 中间表 系统和角色,系统和角色中间表(一个系统下有多个角色,一个角色不能属于多个系统)
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_system_role")
@ApiModel(value="SsoSystemRole对象", description="中间表 系统和角色,系统和角色中间表(一个系统下有多个角色,一个角色不能属于多个系统)")
public class SsoSystemRole extends Model<SsoSystemRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统表code")
    private String systemCode;

    @ApiModelProperty(value = "角色表的code")
    private String roleCode;

    @ApiModelProperty(value = "是否删除 1已删除,0未删除")
    private Integer status;

    @ApiModelProperty(value = "描述")
    private String description;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
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
        return this.systemCode;
    }

    @Override
    public String toString() {
        return "SsoSystemRole{" +
            "systemCode=" + systemCode +
            ", roleCode=" + roleCode +
            ", status=" + status +
            ", description=" + description +
        "}";
    }
}
