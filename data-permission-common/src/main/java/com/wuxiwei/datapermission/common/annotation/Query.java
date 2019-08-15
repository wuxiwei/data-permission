package com.wuxiwei.datapermission.common.annotation;

import com.wuxiwei.datapermission.common.enums.PermissionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuxw
 * @since 2019/8/14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    /**
     * 查询方式
     * @return
     */
    Operation operation() default Operation.EQUAL;

    /**
     * 过滤字段
     * @return
     */
    String whereFiled();

    /**
     * 连接表
     * @return
     */
    boolean join() default false;

    /**
     * 连表字段
     * @return
     */
    PermissionType joinTable() default PermissionType.USER;

    /**
     * 默认内连接
     * @return
     */
    Join joinType() default Join.INNER;


    enum Operation {
        /** 相等 */
        EQUAL
        /** 大于等于 */
        , GREATER_THAN
        /**小于等于 */
        , LESS_THAN
        /** 中模糊查询 */
        , INNER_LIKE
        /** 左模糊查询 */
        , LEFT_LIKE
        /** 右模糊查询 */
        , RIGHT_LIKE
        /** 小于 */
        , LESS_THAN_NQ
        /** 包含 */
        , IN
    }

    enum Join {
        /** 内连接 */
        INNER
        /** 左连接 */
        , LEFT
        /** 右连接 */
        , RIGHT
    }
}
