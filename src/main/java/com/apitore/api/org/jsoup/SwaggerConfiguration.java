package com.apitore.api.org.jsoup;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Keigo Hattori
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  final String PATH = "com.apitore.api.org.jsoup.controller";

  @SuppressWarnings("unchecked")
  @Bean
  public Docket url2htmlAPI() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("url2html")
        .select()
        .apis(RequestHandlerSelectors.basePackage(PATH))
        .paths(or(
            regex(".*/url2html.*")
            ))
        .build()
        .apiInfo(
            new ApiInfoBuilder()
            .title("Url2Html APIs")
            .description("Url to Html.")
            .version("0.0.1")
            .build()
            )
        .directModelSubstitute(Date.class, Long.class);
  }

  @SuppressWarnings("unchecked")
  @Bean
  public Docket url2textAPI() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("url2text")
        .select()
        .apis(RequestHandlerSelectors.basePackage(PATH))
        .paths(or(
            regex(".*/url2text.*")
            ))
        .build()
        .apiInfo(
            new ApiInfoBuilder()
            .title("Url2Text APIs")
            .description("Url to Text.")
            .version("0.0.1")
            .build()
            )
        .directModelSubstitute(Date.class, Long.class);
  }

  @SuppressWarnings("unchecked")
  @Bean
  public Docket url2hrefAPI() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("url2href")
        .select()
        .apis(RequestHandlerSelectors.basePackage(PATH))
        .paths(or(
            regex(".*/url2href.*")
            ))
        .build()
        .apiInfo(
            new ApiInfoBuilder()
            .title("Url2Href APIs")
            .description("Url to Href links.")
            .version("0.0.1")
            .build()
            )
        .directModelSubstitute(Date.class, Long.class);
  }

  @SuppressWarnings("unchecked")
  @Bean
  public Docket url2srcAPI() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("url2src")
        .select()
        .apis(RequestHandlerSelectors.basePackage(PATH))
        .paths(or(
            regex(".*/url2src.*")
            ))
        .build()
        .apiInfo(
            new ApiInfoBuilder()
            .title("Url2Src APIs")
            .description("Url to Image src urls.")
            .version("0.0.1")
            .build()
            )
        .directModelSubstitute(Date.class, Long.class);
  }

}
