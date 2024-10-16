package com.wangxia.core.core.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.core.core.common.domain.LoginHis;
import com.wangxia.core.core.common.domain.User;
import com.wangxia.core.core.common.mapper.LoginHisMapper;
import com.wangxia.core.core.common.service.LoginHisService;
import com.wangxia.core.core.common.utils.IpUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author liur
* @description 针对表【login_his(登录历史)】的数据库操作Service实现
* @createDate 2024-09-12 15:06:26
*/
@Service
public class LoginHisServiceImpl extends ServiceImpl<LoginHisMapper, LoginHis>
    implements LoginHisService{

}




