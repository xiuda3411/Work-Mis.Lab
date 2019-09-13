package cn.edu.cqupt.mislab.work.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sl spx
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket algorithmApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.edu.cqupt.mislab.work.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(enable)
                .useDefaultResponseMessages(false);
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder().title("作业系统接口文档")
                .contact(new Contact("xiuda3411", "xiuda3411.github.io", "1157867526@qq.com"))
                .version("1.0")
                .build();
    }
}
