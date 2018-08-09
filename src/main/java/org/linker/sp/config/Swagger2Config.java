package org.linker.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author RWM
 * @date 2018/7/31
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("小程序API接口")
                        .description("很牛批的API接口文档")
                        .contact(new Contact("阮威敏", "www.linker.com", "rwmingad@163.com"))
                        .version("1.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.linker.sp.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
