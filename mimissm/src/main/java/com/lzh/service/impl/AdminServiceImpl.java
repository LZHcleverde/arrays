package com.lzh.service.impl;

import com.lzh.mapper.AdminMapper;
import com.lzh.pojo.Admin;
import com.lzh.pojo.AdminExample;
import com.lzh.service.AdminService;
import com.lzh.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据名称查询用户对象
        //使用条件，创建AdminExample对象，封装条件
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);

        //比对密码
        if(admins.size() > 0){
            Admin admin = admins.get(0);
            if(MD5Util.getMD5(pwd).equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
