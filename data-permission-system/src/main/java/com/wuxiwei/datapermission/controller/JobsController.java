package com.wuxiwei.datapermission.controller;

import com.wuxiwei.datapermission.common.annotation.DataAuth;
import com.wuxiwei.datapermission.common.enums.BusinessType;
import com.wuxiwei.datapermission.common.enums.PermissionType;
import com.wuxiwei.datapermission.common.utils.QueryHelp;
import com.wuxiwei.datapermission.model.JobsQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuxiwei
 * @date 2019/8/15
 */
@RestController
@RequestMapping("jobs")
public class JobsController {

    @GetMapping("/query")
    @DataAuth(type = BusinessType.JOBS)
    public JobsQuery queryJobs(JobsQuery jobsQuery) {

        try {
            QueryHelp.generateSql(jobsQuery);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int i = 0;
        System.out.println(i);
        return jobsQuery;
    }

    public static void main(String[] args) throws IllegalAccessException {
        JobsQuery jobsQuery = new JobsQuery();
        jobsQuery.setId(10);
        jobsQuery.setName("财务");
        jobsQuery.setUserIds(Arrays.asList("1","2","3"));
        jobsQuery.setDeptIds(Arrays.asList("111","211","311"));
        jobsQuery.setProjectIds(Arrays.asList("11","21","31"));
        QueryHelp.generateSql(jobsQuery);
        System.out.println(jobsQuery.toString());
    }

}
