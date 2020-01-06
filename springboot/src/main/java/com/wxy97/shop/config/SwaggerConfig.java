package com.wxy97.shop.config;

import com.google.common.base.Predicates;
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
 * @Author: wxySmile
 * @Date 20-1-5 上午10:15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .pathMapping("/")
                    // 选择那些路径和api会生成document
                    .select()
                    // 对所有api进行监控
                    .apis(RequestHandlerSelectors.any())
                    //不显示错误的接口地址
                    //错误路径不监控
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))
                    // 对根下所有路径进行监控
                    .paths(PathSelectors.regex("/.*"))
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder().title("springboot_shop接口文档")
                    .contact(new Contact("wxySmile", "http://wxy97.com/", "wxyrrcj@163.com"))
                    .description("个人博客地址：http://wxy97.com/")
                    .version("v1.0")
                    .build();
        }
}
