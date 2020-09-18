package com.hjf.dao;

import com.hjf.entity.SsoRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 中间表 角色和资源表,(一个角色对应多个资源,一个资源也可以属于多个角色 Mapper 接口
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
public interface SsoRolePermissionMapper extends BaseMapper<SsoRolePermission> {

}
