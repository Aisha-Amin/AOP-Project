package spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* spring.aop.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* spring.aop.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("dataLayerExecution() && businessLayerExecution()")
    public void allLayerExecution(){}

    // look for any bean which has dao in between
    @Pointcut("bean(*dao*)")
    public void beanContainingDao(){}


    @Pointcut("within(spring.aop.data..*)")
    public void dataLayerExecutionWithWithin(){}

    @Pointcut("@annotation(spring.aop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
    // custom annotation for track time and only thoese method would be trackable which have track time annotation
}
