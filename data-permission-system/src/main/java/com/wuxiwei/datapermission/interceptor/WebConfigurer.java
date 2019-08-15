package com.wuxiwei.datapermission.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wuxw
 * @since 2019/8/15
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @DataAuth 注解
//        registry.addInterceptor(dataInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public DataInterceptor dataInterceptor() {
        return new DataInterceptor();
    }
}
