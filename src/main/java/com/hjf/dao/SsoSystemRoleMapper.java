package com.hjf.dao;

import com.hjf.entity.SsoSystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 中间表 系统和角色,系统和角色中间表(一个系统下有多个角色,一个角色不能属于多个系统) Mapper 接口
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
public interface SsoSystemRoleMapper extends BaseMapper<SsoSystemRole> {

}
