package com.wangxia.core.test.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OldProxy implements ProxyInterface {
    private String name;

    private Integer age;

    public String save(OldProxy oldProxy){
        System.out.println("保存");
        return oldProxy.toString();
    }

    public String update(OldProxy oldProxy){
        System.out.println("删除成功");
        return oldProxy.toString();
    }

}
