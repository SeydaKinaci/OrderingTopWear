package org.example.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import se.iths.UseCase;

@Aspect
public class TransactionalUseCaseAspect {

    private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

    public TransactionalUseCaseAspect(TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        this.transactionalUseCaseExecutor = transactionalUseCaseExecutor;
    }

    @Pointcut("@within(useCase)")
    void inUseCase(UseCase useCase) {

    }

    @Around("inUseCase(useCase)")
        Object useCase(ProceedingJoinPoint joinPoint, UseCase useCase){
        return transactionalUseCaseExecutor.executeInTransaction(()-> proceed(joinPoint));
    }

    private Object proceed(ProceedingJoinPoint proceedingJoinPoint) {
        try{
            return proceedingJoinPoint.proceed();
        } catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}
