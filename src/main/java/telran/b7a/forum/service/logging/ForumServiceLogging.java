package telran.b7a.forum.service.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Aspect
public class ForumServiceLogging {
	@Pointcut("execution(public * telran.b7a.forum.service.ForumServiceImpl.find*(..))")
	public void bulkingFind() {
	}

	@Pointcut("execution(public * telran.b7a.forum.service.ForumServiceImpl.getPost(String))"
		+ " && args(id)")
	public void findById(String id) {}
	
	@Pointcut("@annotation(PostLogger) && args(.., id)")
	public void annotation(String id) {
		
	}
	
	@Around("bulkingFind()")
	public Object bulkingFindLoggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		long t1 = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		long t2 = System.currentTimeMillis();
		log.info("method - {}, durations = {}", pjp.getSignature().toLongString(), (t2 - t1));
		return retVal;
	}
	@Before("findById(id)")
	public void getPostLogging(String id) {
		log.info("post withid  {} " , id );
	}
	@AfterReturning("annotation(id)")
	public void updatePostLoggin(String id) {
		log.info("post with id {} ", id);
	}
}
