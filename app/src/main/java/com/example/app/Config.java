package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
@Getter
public final class Config {
    public String SPRING_DATASOURCE_URL;

    public Config(@Value("${spring.datasource.url}") String SPRING_DATASOURCE_URL) {
        this.SPRING_DATASOURCE_URL = SPRING_DATASOURCE_URL;
    }
}
