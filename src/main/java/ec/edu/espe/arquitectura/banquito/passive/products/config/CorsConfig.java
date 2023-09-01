package ec.edu.espe.arquitectura.banquito.passive.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://striped-reserve-397605.web.app")
                        .allowedOrigins("https://banquito-backoffice.web.app")
                        .allowedOrigins("https://banquito-web.web.app")
                        .allowedOrigins("https://banquito-tellerapp.web.app")
                        .allowedOrigins("http://localhost:4200")
                        .exposedHeaders("Content-Disposition","Content-Type")
                        .allowedMethods("*");
            }
        };
    }
}