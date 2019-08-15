package com.wuxiwei.datapermission.model;

import com.wuxiwei.datapermission.common.annotation.DataPermission;
import com.wuxiwei.datapermission.common.annotation.Query;
import com.wuxiwei.datapermission.common.annotation.QueryMain;
import com.wuxiwei.datapermission.common.annotation.QuerySql;
import com.wuxiwei.datapermission.common.enums.PermissionType;

import java.util.List;

/**
 * @author wuxiwei
 * @date 2019/8/15
 */
@QueryMain(alise = "a")
public class JobsQuery {

    @Query(whereFiled = "id",
            operation = Query.Operation.EQUAL)
    public Integer id;

    @Query(whereFiled = "name",
            operation = Query.Operation.EQUAL)
    public String name;

    @DataPermission(type = PermissionType.USER)
    @Query(whereFiled = "user_id",
            operation = Query.Operation.IN)
    public List<String> userIds;

    @DataPermission(type = PermissionType.DEPT)
    @Query(join = true, joinTable = PermissionType.USER,
            whereFiled = "dept_id", operation = Query.Operation.IN)
    public List<String> deptIds;

    @DataPermission(type = PermissionType.PROJECT)
    @Query(whereFiled = "project_id",
            operation = Query.Operation.IN)
    public List<String> projectIds;

    @QuerySql
    public String querySql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    @Override
    public String toString() {
        return "JobsQuery{" +
                "name='" + name + '\'' +
                ", userIds=" + userIds +
                ", deptIds=" + deptIds +
                ", projectIds=" + projectIds +
                ", querySql='" + querySql + '\'' +
                '}';
    }
}
