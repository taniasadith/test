package com.TuCine.AccountManagement.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }
}
