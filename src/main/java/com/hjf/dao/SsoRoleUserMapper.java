package com.hjf.dao;

import com.hjf.entity.SsoRoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 中间表 角色和用户,(角色和用户是多对多的的关系) Mapper 接口
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
public interface SsoRoleUserMapper extends BaseMapper<SsoRoleUser> {

}
