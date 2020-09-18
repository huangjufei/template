package com.hjf.service.impl;

import com.hjf.entity.SsoSystemRole;
import com.hjf.dao.SsoSystemRoleMapper;
import com.hjf.service.SsoSystemRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 中间表 系统和角色,系统和角色中间表(一个系统下有多个角色,一个角色不能属于多个系统) 服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class SsoSystemRoleServiceImpl extends ServiceImpl<SsoSystemRoleMapper, SsoSystemRole> implements SsoSystemRoleService {

}
