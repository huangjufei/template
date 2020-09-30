package com.hjf.service;

import com.hjf.entity.SsoSystem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统表 服务类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
public interface SsoSystemService extends IService<SsoSystem> {

    List<SsoSystem> getSsoSystemByRoleCode(String roleCode);
}
