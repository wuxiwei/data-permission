package com.wuxiwei.datapermission.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

/**
 * @author wuxw
 * @since 2019/8/14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataPermission {

    /**
     * 查询方式
     * @return
     */
    Type type() default Type.EQUAL;

    /**
     * 过滤字段
     * @return
     */
    String whereFiled() default "";

    /**
     * 连表字段
     * @return
     */
    String onFiled() default "";

    /**
     * 连表字段
     * @return
     */
    String onTargetFiled() default "id";

    /**
     * 连接表
     * @return
     */
    String joinTable() default "";

    /**
     * 默认内连接
     * @return
     */
    Join join() default Join.INNER;


    enum Type {
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
