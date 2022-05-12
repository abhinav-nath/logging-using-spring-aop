package com.codecafe.spring.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class LoggingAspect {

  /**
   * Pointcut that matches all the REST controllers
   */
  @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
  public void inControllers() {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }

  @Before("inControllers()")
  public void beforeHttpLogging(JoinPoint joinPoint) {
    Logger logger = this.logger(joinPoint);
    HttpServletRequest request = extractRequest();
    StringBuilder sb = new StringBuilder().append(request.getMethod())
                                          .append(" ")
                                          .append(request.getRequestURI());
    logger.info("Incoming Request : {}", sb);
  }

  /**
   * Retrieves the {@link Logger} associated to the given {@link JoinPoint}.
   *
   * @param joinPoint join point we want the logger for.
   * @return {@link Logger} associated to the given {@link JoinPoint}.
   */
  private Logger logger(JoinPoint joinPoint) {
    return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
  }

  private HttpServletRequest extractRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
  }

}
