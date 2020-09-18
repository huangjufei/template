package com.hjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 系统表
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@TableName("sso_system")
@ApiModel(value="SsoSystem对象", description="系统表")
public class SsoSystem extends Model<SsoSystem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一关联键")
    private String systemCode;

    @ApiModelProperty(value = "名称")
    private String systemName;

    @ApiModelProperty(value = "ip")
    private String address;

    @ApiModelProperty(value = "是否删除")
    private String status;

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

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return this.systemCode;
    }

    @Override
    public String toString() {
        return "SsoSystem{" +
            "systemCode=" + systemCode +
            ", systemName=" + systemName +
            ", address=" + address +
            ", status=" + status +
            ", description=" + description +
            ", createBy=" + createBy +
            ", createDate=" + createDate +
            ", updateDy=" + updateDy +
            ", updateDate=" + updateDate +
        "}";
    }
}
