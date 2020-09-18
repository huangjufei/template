package com.hjf.service.impl;

import com.hjf.entity.SsoUser;
import com.hjf.dao.SsoUserMapper;
import com.hjf.service.SsoUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class SsoUserServiceImpl extends ServiceImpl<SsoUserMapper, SsoUser> implements SsoUserService {

}
