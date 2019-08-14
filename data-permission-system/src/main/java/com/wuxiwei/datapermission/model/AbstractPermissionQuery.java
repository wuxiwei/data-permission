package com.wuxiwei.datapermission.model;

import java.util.List;

/**
 * @author wuxw
 * @since 2019/8/14
 */
public class AbstractPermissionQuery {

    private List<String> userIds;

    private List<String> deptIds;

    private List<String> projectIds;

}


// select * from jobs a join user b on a.user_id on b.user_id where b.dept_id in (deptIds) and a.user_id in (userIds) and a.project_id in (projectIds)

