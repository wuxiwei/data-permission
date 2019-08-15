package com.wuxiwei.datapermission.common.utils;

import com.sun.deploy.util.StringUtils;
import com.wuxiwei.datapermission.common.annotation.Query;
import com.wuxiwei.datapermission.common.annotation.QueryMain;
import com.wuxiwei.datapermission.common.annotation.QuerySql;
import com.wuxiwei.datapermission.common.enums.PermissionType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * sql
 * @author wuxw
 * @since 2019/8/15
 */
public class QueryHelp {

    private static final String ON = " on ";
    private static final String IN = " in ";
    private static final String JOIN = " join ";
    private static final String AND = " and ";
    private static final String WHERE = " where ";

    public static <Q> void generateSql(Q query) throws IllegalAccessException {

        Class<?> aClass = query.getClass();
        QueryMain mainAnnotation = aClass.getAnnotation(QueryMain.class);
        if (mainAnnotation == null) {
            return;
        }
        Field[] fields = aClass.getFields();

        List<String> whereSql = new ArrayList<>();
        List<String> joinSql = new ArrayList<>();
        Field sqlFile = null;

        for (Field field : fields) {
            QuerySql sqlAnnotation = field.getAnnotation(QuerySql.class);
            if (sqlAnnotation != null) {
                sqlFile = field;
                continue;
            }
            Query queryAnnotation = field.getAnnotation(Query.class);
            if (queryAnnotation == null) {
                continue;
            }
            Object val = field.get(query);
            if (val != null) {
                if (queryAnnotation.join()) {
                    PermissionType permissionType = queryAnnotation.joinTable();
                    Query.Join joinType = queryAnnotation.joinType();
                    String alise = permissionType.name();

                    String join = joinType.name() + JOIN + permissionType.getTable() +
                            " " + alise + ON + mainAnnotation.alise() + "." + permissionType.getForeign() +
                            " = " + alise + "." + permissionType.getPrimary();
                    String where = buildWhere(alise, field, queryAnnotation, val);

                    joinSql.add(join);
                    whereSql.add(0, where);
                } else {
                    String sql = buildWhere(mainAnnotation.alise(), field, queryAnnotation, val);
                    whereSql.add(sql);
                }
            }
        }

        String sql = " ";
        if (joinSql.size() > 0) {
            sql += StringUtils.join(joinSql, " ");
        }
        if (whereSql.size() > 0) {
            sql += WHERE + StringUtils.join(whereSql, AND);
        }
        if (sqlFile != null) {
            sqlFile.set(query, sql);
        }
    }

    private static String buildWhere(String alise, Field field, Query queryAnnotation, Object val) {
        String whereFiled = queryAnnotation.whereFiled();
        Query.Operation operation = queryAnnotation.operation();
        String sql = alise + "." + whereFiled;

        switch (operation) {
            case IN:
                sql += IN + "(" + typeCoding(field.getType(), val) + ")";
                break;
            case EQUAL:
                sql += " = " + typeCoding(field.getType(), val);
                break;
        }
        return sql;
    }

    private static String typeCoding(Class<?> type, Object val) {
        String sql = "";
        if (type == List.class) {
            List<String> list = new ArrayList<>();
            Collection collection = (Collection) val;
            collection.forEach(v -> {
                Class<?> aClass = v.getClass();
                list.add(typeCoding(aClass, v));
            });
            sql += StringUtils.join(list,",");
        } else if (type == String.class) {
            sql += "\"" + val + "\"";
        } else if (type == Integer.class) {
            sql += val;
        }

        return sql;
    }
}
