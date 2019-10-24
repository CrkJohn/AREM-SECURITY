package edu.eci.arem.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * A class used to represent a instance for can encript a password
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     *
     * @return  instance of  BCryptPasswordEncoder that let encript a password
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}