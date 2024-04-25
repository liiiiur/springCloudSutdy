package com.wangxia.core.core.common.controller;

import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.constant.HttpStatus;
import com.wangxia.core.core.common.domain.LoginUser;
import com.wangxia.core.core.common.domain.Permission;
import com.wangxia.core.core.common.domain.Role;
import com.wangxia.core.core.common.domain.Userrole;
import com.wangxia.core.core.common.service.PermissionService;
import com.wangxia.core.core.common.service.RoleService;
import com.wangxia.core.core.common.service.UserService;
import com.wangxia.core.core.common.service.UserroleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
@Tag(name = "核心服务")
public class SecurityController {

    private final UserService userService;

    private final RoleService roleService;

    private final PermissionService permissionService;

    private final UserroleService userroleService;

    @Autowired
    public SecurityController(UserService userService, RoleService roleService, PermissionService permissionService, UserroleService userroleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.userroleService = userroleService;
    }

    @Operation(description = "没有登录",summary = "未登录")
    @RequestMapping(method = RequestMethod.GET,value = "/needLogin")
    public AjaxResult needLogin(){
        return AjaxResult.error(HttpStatus.UNAUTHORIZED,"登录失效");
    }

    @Operation(description = "登录账号",summary = "登录")
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public AjaxResult login(@RequestBody LoginUser loginUser){
        return AjaxResult.success(loginUser);
    }

    @Operation(description = "新增用户",summary = "新增用户")
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public AjaxResult addUser(@RequestBody LoginUser user){
        boolean save=false;
        if(userService.validateUser(user)){
            userService.createUser(user);
        }
        return AjaxResult.success(save);
    }

    @Operation(description = "新增角色",summary = "新增角色")
    @RequestMapping(method = RequestMethod.POST,value = "/role")
    public AjaxResult addRole(@RequestBody Role role){
        boolean save = roleService.save(role);
        return AjaxResult.success(save);
    }

    @Operation(description = "新增权限",summary = "新增权限")
    @RequestMapping(method = RequestMethod.POST,value = "/permission")
    public AjaxResult addPermission(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        return AjaxResult.success(save);
    }

    @Operation(description = "新增用户角色",summary = "新增用户角色")
    @PostMapping("/userrole")
    public AjaxResult addUserrole(@RequestBody Userrole userrole){
        boolean save = userroleService.save(userrole);
        return AjaxResult.success(save);
    }

}
