package com.wuxiwei.datapermission.common.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author wuxw
 * @since 2019/8/15
 */
public enum BusinessType {
    JOBS("岗位", "jobs", Arrays.asList(PermissionType.USER, PermissionType.DEPT, PermissionType.PROJECT)),
    ;

    BusinessType(String name, String code, List<PermissionType> types) {
        this.name = name;
        this.code = code;
        this.types = types;
    }

    String name;
    String code;
    List<PermissionType> types;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<PermissionType> getTypes() {
        return types;
    }}
