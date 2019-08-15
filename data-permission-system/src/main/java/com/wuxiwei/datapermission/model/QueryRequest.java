package com.wuxiwei.datapermission.model;

import com.wuxiwei.datapermission.common.annotation.QueryMain;

/**
 * @author wuxw
 * @since 2019/8/14
 */
@QueryMain(as = "a")
public class QueryRequest {

    private String name;

//    @DataPermission(whereFiled = "user_id", operation = DataPermission.Operation.IN)
//    private List<String> userIds;
//
//    @DataPermission(joinTable = "user", onFiled = "user_id", onTargetFiled = "user_id",
//            whereFiled = "dept_id", operation = DataPermission.Operation.IN)
//    private List<String> deptIds;
//
//    @DataPermission(whereFiled = "project_id", operation = DataPermission.Operation.IN)
//    private List<String> projectIds;

    private String sqlPermission;

}


// select * from jobs a join user b on a.user_id on b.user_id where b.dept_id in (deptIds) and a.user_id in (userIds) and a.project_id in (projectIds)

