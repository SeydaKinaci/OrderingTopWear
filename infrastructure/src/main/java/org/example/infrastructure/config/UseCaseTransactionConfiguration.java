package org.example.infrastructure.config;

import org.example.infrastructure.aop.TransactionalUseCaseAspect;
import org.example.infrastructure.aop.TransactionalUseCaseExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class UseCaseTransactionConfiguration {

    @Bean
    @Transactional(isolation = Isolation.SERIALIZABLE)
    TransactionalUseCaseExecutor transactionalUseCaseExecutor() {
        return new TransactionalUseCaseExecutor();
    }

    @Bean
    TransactionalUseCaseAspect transactionalUseCaseAspect(TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        return new TransactionalUseCaseAspect(transactionalUseCaseExecutor);
    }
}
