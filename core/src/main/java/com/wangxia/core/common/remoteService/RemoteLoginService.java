package com.wangxia.core.common.remoteService;

import com.wangxia.core.common.constant.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core",path = "/common")
public interface RemoteLoginService {
    @GetMapping("/user/{username}")
    AjaxResult findUserByUsername(@PathVariable("username") String username);
}
