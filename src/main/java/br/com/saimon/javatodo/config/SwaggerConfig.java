package br.com.saimon.javatodo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("br.com.saimon.javatodo");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage)
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("RestFul Api With Spring Boot",
                "Java To Do",
                "v1",
                "Terms of Service URL",
                new Contact("Saimon Ribeiro", "linkedin","saimonribeiros@hotmail.com"),
                "Licence of Api",
                "licence Of URL",
                Collections.emptyList());
    }
}
