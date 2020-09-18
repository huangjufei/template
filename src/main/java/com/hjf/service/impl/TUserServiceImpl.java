package com.hjf.service.impl;

import com.hjf.entity.TUser;
import com.hjf.dao.TUserMapper;
import com.hjf.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
