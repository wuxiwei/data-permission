package com.wuxiwei.datapermission.interceptor;

import com.wuxiwei.datapermission.common.annotation.DataAuth;
import com.wuxiwei.datapermission.common.annotation.DataPermission;
import com.wuxiwei.datapermission.common.enums.BusinessType;
import com.wuxiwei.datapermission.common.enums.PermissionType;
import com.wuxiwei.datapermission.controller.JobsController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuxw
 * @since 2019/8/15
 */
public class DataInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // START 方法注解级拦截器
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        DataAuth methodAnnotation = method.getAnnotation(DataAuth.class);
        // 有 @DataAuth 注解
        if (methodAnnotation != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class c : parameterTypes) {
                Field[] fields = c.getFields();
                for (Field field : fields) {
                    DataPermission annotation = field.getAnnotation(DataPermission.class);
                    if (annotation != null && methodAnnotation.type().getTypes().contains(annotation.type())) {
                        // 当前业务支持数据维度
                        switch (annotation.type()) {
                            case USER:
                                List<String> tempUser = Arrays.asList("1","2","3","4");
                                request.setAttribute(field.getName(), tempUser);
                                break;
                            case DEPT:
                                List<String> tempDept = Arrays.asList("10","20","30","40");
                                request.setAttribute(field.getName(), tempDept);
                                break;
                            case PROJECT:
                                List<String> tempProject = Arrays.asList("11","21","31","41");
                                request.setAttribute(field.getName(), tempProject);
                                break;
                        }
                    }
                }
            }
            return true;
        }
        return true;
    }
}
