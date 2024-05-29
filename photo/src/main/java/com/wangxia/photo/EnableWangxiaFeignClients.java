package com.wangxia.photo;

import org.springframework.cloud.openfeign.EnableFeignClients;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableWangxiaFeignClients {
    String[] value() default {};

    String[] basePackages() default { "com.wangxia" };

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
