package com.godie.Blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@Nullable CorsRegistry registry) {
                if (registry != null) {
                    registry.addMapping("/**")
                            .allowedOrigins("http://blog.cfapps.us10-001.hana.ondemand.com",
                                    "https://blog.cfapps.us10-001.hana.ondemand.com",
                                    "http://javablog.netlify.app",
                                    "https://javablog.netlify.app",
                                    "http://localhost:5173",
                                    "http://localhost:8989"
                            )
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                            .allowCredentials(true).maxAge(3600)
                            .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                                    HttpHeaders.AUTHORIZATION, "token");
                }
            }
        };
    }

}