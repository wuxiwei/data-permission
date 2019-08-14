package com.wuxiwei.datapermission.model;

import com.wuxiwei.datapermission.common.annotation.DataPermission;

import java.util.List;

/**
 * @author wuxiwei
 * @date 2019/8/15
 */
public class JobsQuery {

    public String name;

    @DataPermission(whereFiled = "user_id", type = DataPermission.Type.IN)
    private List<String> userIds;

    @DataPermission(joinTable = "user", onFiled = "user_id", onTargetFiled = "user_id",
            whereFiled = "dept_id", type = DataPermission.Type.IN)
    private List<String> deptIds;

    @DataPermission(whereFiled = "project_id", type = DataPermission.Type.IN)
    private List<String> projectIds;

}
