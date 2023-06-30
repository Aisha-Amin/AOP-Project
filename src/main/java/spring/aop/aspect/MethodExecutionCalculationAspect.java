package spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept (Point cut)
    //execution(* PACKAGE.*.*(..))

//Weaving & Weaver

    // check the time taken for a method to run
    @Around(value="spring.aop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); // start time

        Object retVal = proceedingJoinPoint.proceed(); // continued with execution

        long timeTaken = System.currentTimeMillis() - startTime; // end time

        logger.info(" Time taken by {} is  {} ", proceedingJoinPoint,timeTaken);

        return retVal;
    }

}
