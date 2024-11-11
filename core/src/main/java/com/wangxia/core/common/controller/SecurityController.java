package com.wangxia.core.common.controller;

import com.wangxia.core.common.domain.*;
import com.wangxia.core.common.constant.AjaxResult;
import com.wangxia.core.common.dto.LoginUserDto;
import com.wangxia.core.common.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限控制
 */
@RestController
@RequestMapping("/common")
@Tag(name = "核心服务")
public class SecurityController {

    private final UserService userService;

    private final RoleService roleService;

    private final PermissionService permissionService;

    private final UserroleService userroleService;

    private final RolePermissionService rolePermissionService;

    @Autowired
    public SecurityController(UserService userService, RoleService roleService, PermissionService permissionService, UserroleService userroleService, RolePermissionService rolePermissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.userroleService = userroleService;
        this.rolePermissionService = rolePermissionService;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public AjaxResult addUser(@RequestBody User user){
        if(userService.isHaveUser(user)){
            user.setIsAdmin(0);
            user.setIsEnable(1);
            String id = userService.createUser(user);
            if(id!=null){
                return AjaxResult.success(id);
            }
        }
        return AjaxResult.error("保存失败");
    }

    /**
     * 账号查找用户
     * @param username 用户名
     * @return
     */
    @GetMapping("/user/{username}")
    public AjaxResult findUserByUsername(@PathVariable("username") String username){
        LoginUserDto userByUsername = userService.getUserByUsername(username);
        return AjaxResult.success(userByUsername);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/role")
    public AjaxResult addRole(@RequestBody Role role){
        boolean save = roleService.saveRole(role);
        return AjaxResult.success(save);
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/permission")
    public AjaxResult addPermission(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        return AjaxResult.success(save);
    }

    /**
     * 关联用户角色
     * @param userrole
     * @return
     */
    @PostMapping("/userrole")
    public AjaxResult addUserrole(@RequestBody Userrole userrole){
        boolean save = userroleService.save(userrole);
        return AjaxResult.success(save);
    }

    /**
     * 关联角色权限
     * @param role 角色
     * @param permissionList 权限列表
     * @return
     */
    @PostMapping("saveRolePermission")
    public AjaxResult addRolePermission(@RequestBody Role role, List<Permission> permissionList){
        rolePermissionService.addRolePermission(role,permissionList);
        return AjaxResult.success();
    }

}
