package com.moondev.OneHealth.config;

import com.moondev.OneHealth.date.LocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
    @Override public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class,new LocalDateFormatter());
    }
}
