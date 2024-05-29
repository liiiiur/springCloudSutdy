package com.wangxia.core.core.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private List<String> permissions;

    private Boolean rememberMe;
}
