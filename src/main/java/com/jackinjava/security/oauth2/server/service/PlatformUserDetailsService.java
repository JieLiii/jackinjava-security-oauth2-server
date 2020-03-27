package com.jackinjava.security.oauth2.server.service;

import com.jackinjava.security.oauth2.server.mapper.PermissionMapper;
import com.jackinjava.security.oauth2.server.mapper.UserMapper;
import com.jackinjava.security.oauth2.server.model.Permission;
import com.jackinjava.security.oauth2.server.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @date 2020/3/10 18:39
 */
@Service
public class PlatformUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(PlatformUserDetailsService.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user = userMapper.findUserByUserName(userName);
        if(user != null) {
            List<Permission> permissions = permissionMapper.findPermissionByUserId(user.getUserId());
            user.setPermissions(permissions);
            return  user;
        }
        return null;
    }
}
