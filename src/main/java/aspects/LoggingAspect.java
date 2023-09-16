package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import model.Comment;
import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger log = MyUtil.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* services.*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		String calledMethod = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		
		var sb = new StringBuffer("차단된 메소드명: ");
		sb.append(calledMethod);
		sb.append(", 원래 인자목록: ");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(Arrays.asList(arguments));
		sb.append(", 호출 전");
		log.info(sb.toString());
		
		var comment = new Comment();
		comment.setAuthor("보리스");
		comment.setText("지바고 이야기");
		Object[] myArgs = {comment};
		
		Object result = joinPoint.proceed(myArgs);
		log.info("원래 메소드 실행 결과 반환값 : " + result);
		return "실패";
	}
}
