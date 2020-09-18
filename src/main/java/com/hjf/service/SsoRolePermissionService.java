package com.hjf.service;

import com.hjf.entity.SsoRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 中间表 角色和资源表,(一个角色对应多个资源,一个资源也可以属于多个角色 服务类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
public interface SsoRolePermissionService extends IService<SsoRolePermission> {

}
