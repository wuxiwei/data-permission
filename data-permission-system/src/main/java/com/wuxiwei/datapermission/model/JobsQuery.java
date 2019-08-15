package com.wuxiwei.datapermission.model;

import com.wuxiwei.datapermission.common.annotation.DataPermission;
import com.wuxiwei.datapermission.common.annotation.Query;
import com.wuxiwei.datapermission.common.enums.PermissionType;

import java.util.List;

/**
 * @author wuxiwei
 * @date 2019/8/15
 */
public class JobsQuery {

    public String name;

    @DataPermission(type = PermissionType.USER)
    @Query(whereFiled = "user_id",
            operation = Query.Operation.IN)
    public List<String> userIds;

    @DataPermission(type = PermissionType.DEPT)
    @Query(joinTable = "user", onFiled = "user_id", onTargetFiled = "user_id",
            whereFiled = "dept_id", operation = Query.Operation.IN)
    public List<String> deptIds;

    @DataPermission(type = PermissionType.PROJECT)
    @Query(whereFiled = "project_id",
            operation = Query.Operation.IN)
    public List<String> projectIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }
}
