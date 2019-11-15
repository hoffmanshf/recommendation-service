package com.hoffmanshf.recommendation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hoffmanshf.recommendation"})
@MapperScan("com.hoffmanshf.recommendation.dal")
public class RecommendationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }

}
