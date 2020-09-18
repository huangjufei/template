package com.hjf.service.impl;

import com.hjf.entity.SsoRolePermission;
import com.hjf.dao.SsoRolePermissionMapper;
import com.hjf.service.SsoRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 中间表 角色和资源表,(一个角色对应多个资源,一个资源也可以属于多个角色 服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class SsoRolePermissionServiceImpl extends ServiceImpl<SsoRolePermissionMapper, SsoRolePermission> implements SsoRolePermissionService {

}
