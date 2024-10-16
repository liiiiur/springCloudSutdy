package com.wangxia.core.core.common.service;

import com.wangxia.core.core.common.domain.LoginHis;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangxia.core.core.common.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
* @author liur
* @description 针对表【login_his(登录历史)】的数据库操作Service
* @createDate 2024-09-12 15:06:26
*/
public interface LoginHisService extends IService<LoginHis> {
}
