package com.goodhealth.provider.eurake.service.Impl;

import com.goodhealth.provider.eurake.pojo.User;
import com.goodhealth.provider.eurake.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUser() {
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"zhangsan",20));
        list.add(new User(2,"lisi",22));
        list.add(new User(3,"wangwu",20));
        return list;
    }
}
