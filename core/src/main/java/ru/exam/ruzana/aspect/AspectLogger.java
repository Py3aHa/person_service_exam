package ru.exam.ruzana.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.exam.ruzana.model.LogEntity;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.service.LogEntityService;

import java.time.LocalDateTime;

@Aspect
@Component
public class AspectLogger {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogEntityService logService;

    @Pointcut("execution(public * ru.exam.ruzana.controller.impl.*.*(..))")
    public void callAtRestPublic() { }

    @Before("callAtRestPublic()")
    public void beforeCallAtMethod1(JoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();

        LogEntity logEntity = new LogEntity(null, LocalDateTime.now(), methodName, className, null);
        logService.add(logEntity);

        PersonDataEntity personDataEntity = (PersonDataEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object[] array = pjp.getArgs();
        logger.info("before : " + methodName +
                " from   ->   " + className +
                ",    args=[" + mapper.writeValueAsString(array) +
                "]    -->   user : " + personDataEntity.getFirstName() +
                " " + personDataEntity.getLastName());
    }

    @After("callAtRestPublic()")
    public void afterCallAt(JoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();

        String userName = "NULL";
        if(SecurityContextHolder.getContext().getAuthentication() != null){
            PersonDataEntity personDataEntity = (PersonDataEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userName = personDataEntity.getFirstName() + " " + personDataEntity.getLastName();
        }

        LogEntity logEntity = new LogEntity(null, LocalDateTime.now(), methodName, className, userName);
        logService.add(logEntity);

        Object[] array = pjp.getArgs();
        logger.info("after : " + methodName +
                " from   ->   " + className +
                ",    args=[" + mapper.writeValueAsString(array) +
                "]    -->   user : " + userName);
    }
}
