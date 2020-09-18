package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 中间表 角色和资源表,(一个角色对应多个资源,一个资源也可以属于多个角色
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_role_permission")
@ApiModel(value="SsoRolePermission对象", description="中间表 角色和资源表,(一个角色对应多个资源,一个资源也可以属于多个角色")
public class SsoRolePermission extends Model<SsoRolePermission> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色code")
    private String roleCode;

    @ApiModelProperty(value = "资源code")
    private String permissionCode;

    @ApiModelProperty(value = "是否有添加")
    private String permissionAdd;

    @ApiModelProperty(value = "是否有删除")
    private String permissionDelete;

    @ApiModelProperty(value = "是否有修改")
    private String permissionUpdate;

    @ApiModelProperty(value = "是否有查询")
    private String permissionSelect;

    @ApiModelProperty(value = "是否删除 1已删除,0未删除")
    private Integer status;

    @ApiModelProperty(value = "描述")
    private String description;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
    public String getPermissionAdd() {
        return permissionAdd;
    }

    public void setPermissionAdd(String permissionAdd) {
        this.permissionAdd = permissionAdd;
    }
    public String getPermissionDelete() {
        return permissionDelete;
    }

    public void setPermissionDelete(String permissionDelete) {
        this.permissionDelete = permissionDelete;
    }
    public String getPermissionUpdate() {
        return permissionUpdate;
    }

    public void setPermissionUpdate(String permissionUpdate) {
        this.permissionUpdate = permissionUpdate;
    }
    public String getPermissionSelect() {
        return permissionSelect;
    }

    public void setPermissionSelect(String permissionSelect) {
        this.permissionSelect = permissionSelect;
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
        return this.roleCode;
    }

    @Override
    public String toString() {
        return "SsoRolePermission{" +
            "roleCode=" + roleCode +
            ", permissionCode=" + permissionCode +
            ", permissionAdd=" + permissionAdd +
            ", permissionDelete=" + permissionDelete +
            ", permissionUpdate=" + permissionUpdate +
            ", permissionSelect=" + permissionSelect +
            ", status=" + status +
            ", description=" + description +
        "}";
    }
}
