package com.wuxiwei.datapermission.common.enums;

/**
 * 数据控制维度
 * @author wuxw
 * @since 2019/8/15
 */
public enum PermissionType {

    USER("用户", "user", "id", "user_id"),
    DEPT("部门", "dept", "id", "dept_id"),
    PROJECT("项目", "project", "id", "project_id")
    ;

    PermissionType(String name, String table, String primary, String foreign) {
        this.name = name;
        this.table = table;
        this.primary = primary;
        this.foreign = foreign;
    }

    String name;
    String table;
    String primary;
    String foreign;

    public String getPrimary() {
        return primary;
    }

    public String getTable() {
        return table;
    }

    public String getName() {
        return name;
    }

    public String getForeign() {
        return foreign;
    }
}
