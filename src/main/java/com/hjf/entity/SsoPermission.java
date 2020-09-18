package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_permission")
@ApiModel(value="SsoPermission对象", description="资源表")
public class SsoPermission extends Model<SsoPermission> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限标识符")
    private String permissionCode;

    @ApiModelProperty(value = "请求地址")
    private String url;

    @ApiModelProperty(value = "是否删除 1已删除,0未删除")
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

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return this.permissionCode;
    }

    @Override
    public String toString() {
        return "SsoPermission{" +
            "permissionCode=" + permissionCode +
            ", url=" + url +
            ", status=" + status +
            ", description=" + description +
            ", createBy=" + createBy +
            ", createDate=" + createDate +
            ", updateDy=" + updateDy +
            ", updateDate=" + updateDate +
        "}";
    }
}
