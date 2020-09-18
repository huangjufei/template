package com.hjf.service;

import com.github.pagehelper.PageInfo;
import com.hjf.entity.UserDomain;

public interface UserService {

    Integer addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}