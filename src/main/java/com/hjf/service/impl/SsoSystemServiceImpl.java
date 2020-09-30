package com.hjf.service.impl;

import com.hjf.entity.SsoSystem;
import com.hjf.dao.SsoSystemMapper;
import com.hjf.service.SsoSystemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统表 服务实现类
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Service
public class SsoSystemServiceImpl extends ServiceImpl<SsoSystemMapper, SsoSystem> implements SsoSystemService {


    @Autowired
    private SsoSystemMapper ssoSystemMapper;

    /**
     * 通过在xml中写sql来查询,动态性最高
     * @param roleCode
     * @return
     */
    @Override
    public List<SsoSystem> getSsoSystemByRoleCode(String roleCode){
       List<SsoSystem> list = ssoSystemMapper.getSsoSystemByRoleCode(roleCode);
       return list;
    }

}
