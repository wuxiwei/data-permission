package com.wuxiwei.datapermission.controller;

import com.wuxiwei.datapermission.model.JobsQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiwei
 * @date 2019/8/15
 */
@RestController
public class JobsController {

    @GetMapping("/query")
    public String queryJobs(JobsQuery jobsQuery) {


        return "";
    }

}
