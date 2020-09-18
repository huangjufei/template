package com.hjf.service.impl;

import com.hjf.entity.SsoRoleUser;
import com.hjf.dao.SsoRoleUserMapper;
import com.hjf.service.SsoRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 中间表 角色和用户,(角色和用户是多对多的的关系) 服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class SsoRoleUserServiceImpl extends ServiceImpl<SsoRoleUserMapper, SsoRoleUser> implements SsoRoleUserService {

}
