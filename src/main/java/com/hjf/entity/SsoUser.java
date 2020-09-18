package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_user")
@ApiModel(value="SsoUser对象", description="用户表")
public class SsoUser extends Model<SsoUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一关联键")
    private String userCode;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "全名")
    @TableField("full_Name")
    private String fullName;

    @ApiModelProperty(value = "盐")
    private String salt;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        return this.userCode;
    }

    @Override
    public String toString() {
        return "SsoUser{" +
            "userCode=" + userCode +
            ", username=" + username +
            ", password=" + password +
            ", fullName=" + fullName +
            ", salt=" + salt +
            ", status=" + status +
            ", description=" + description +
            ", createBy=" + createBy +
            ", createDate=" + createDate +
            ", updateDy=" + updateDy +
            ", updateDate=" + updateDate +
        "}";
    }
}
