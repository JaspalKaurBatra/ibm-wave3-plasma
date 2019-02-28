package com.stackroute.knowledgequeryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(metaInfo());   //custom configuration
    }

    private ApiInfo metaInfo() {

        return new ApiInfoBuilder()
                .title("Knowledge Query Service")
                .description("\"Query Responsibility(R)\"")
                .version("1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Jaspal Kaur Batra", "https://github.com/JaspalKaurBatra", "jaspalkaurbatra95@gmail.com"))
                .build();

    }
}

