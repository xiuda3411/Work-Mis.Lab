package cn.edu.cqupt.mislab.work.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;

/**
 * @program: work-Mis.Lab
 * @description: 拦截器
 * @author: 宋丽
 * @create: 2019-11-22 20:58
 **/
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;


    /**
     * 拦截器配置
     * @param registry 注册类
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/User/login");
                //.excludePathPatterns("/User/login");

    }
}

