package org.example.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import se.iths.UseCase;

@Configuration
@ComponentScan(
        basePackages = "se.iths",
        includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, value= UseCase.class)
)
public class DomainConfig {


}
