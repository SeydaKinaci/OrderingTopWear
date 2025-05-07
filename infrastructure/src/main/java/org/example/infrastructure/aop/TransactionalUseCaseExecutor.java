package org.example.infrastructure.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public class TransactionalUseCaseExecutor {

    static final Logger log = LoggerFactory.getLogger(TransactionalUseCaseExecutor.class);

    public <T> T executeInTransaction(Supplier<T> execution){
        log.info("Executing in-transaction");
        return execution.get();
    }
}
