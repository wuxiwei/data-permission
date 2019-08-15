package com.wuxiwei.datapermission.common.enums;

/**
 * 数据控制维度
 * @author wuxw
 * @since 2019/8/15
 */
public enum PermissionType {

    USER("用户"),
    DEPT("部门"),
    PROJECT("项目")
    ;

    PermissionType(String name) {
        this.name = name;
    }

    String name;
}
