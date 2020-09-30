package com.hjf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjf.entity.SsoSystem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统表 Mapper 接口
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Repository
public interface SsoSystemMapper extends BaseMapper<SsoSystem> {
    // 调用xml文件
    List<SsoSystem> getSsoSystemByRoleCode(String roleCode);
}
