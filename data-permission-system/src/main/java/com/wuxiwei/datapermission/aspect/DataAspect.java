package com.wuxiwei.datapermission.aspect;

import com.wuxiwei.datapermission.common.annotation.DataAuth;
import com.wuxiwei.datapermission.common.annotation.DataPermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuxw
 * @since 2019/8/15
 */
@Aspect
@Component
public class DataAspect {

    //PointCut表达式
    @Pointcut("execution(* com.wuxiwei.datapermission..*.*(..)) && @annotation(com.wuxiwei.datapermission.common.annotation.DataAuth)")
    public void dataAnnotation() {}

    @Before(value = "dataAnnotation() && @annotation(dataAuth)")
    public void doBefore(JoinPoint joinPoint, DataAuth dataAuth) throws IllegalAccessException {
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            Class<?> aClass = o.getClass();
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                DataPermission annotation = field.getAnnotation(DataPermission.class);
                if (annotation != null && dataAuth.type().getTypes().contains(annotation.type())) {
                    // 当前业务支持数据维度
                    // 根据业务支持获取相应的可见范围
                    switch (annotation.type()) {
                        case USER:
                            List<String> tempUser = Arrays.asList("1","2","3","4");
                                field.set(o, tempUser);
                            break;
                        case DEPT:
                            List<String> tempDept = Arrays.asList("10","20","30","40");
                                field.set(o, tempDept);
                            break;
                        case PROJECT:
                            List<String> tempProject = Arrays.asList("11","21","31","41");
                                field.set(o, tempProject);
                            break;
                    }
                }
            }
        }

    }

}
