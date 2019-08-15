package com.wuxiwei.datapermission.common.annotation;

import com.wuxiwei.datapermission.common.enums.BusinessType;
import com.wuxiwei.datapermission.common.enums.PermissionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuxw
 * @since 2019/8/14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataAuth {

    /**
     * 业务类型
     * @return
     */
    BusinessType type();
}
