package aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger log = MyUtil.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* services.*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("차단된 메소드 호출 전");
		Object result = joinPoint.proceed();
		log.info("차단된 메소드 호출 후 반환값 : " + result);
		return result;
	}
}
