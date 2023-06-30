package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept (Point cut)
    //execution(* PACKAGE.*.*(..))

//Weaving & Weaver
    @Before("execution(* spring.aop.business.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Check for user access ");
        logger.info("Allowed execution for  {}", joinPoint);
    }
}
