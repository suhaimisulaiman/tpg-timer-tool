package au.com.tpg.profiling.core;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class Profiler {
	
	public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(proceedingJoinPoint.toShortString());
		boolean isExceptionThrown = false;
		try {
			// execute the profiled method
			return proceedingJoinPoint.proceed();
		} catch (RuntimeException e) {
			isExceptionThrown = true;
			throw e;
		} finally {
			stopWatch.stop();
			TaskInfo taskInfo = stopWatch.getLastTaskInfo();
			// Log the method's profiling result
			String profileMessage = taskInfo.getTaskName() + ": " + taskInfo.getTimeMillis() + " ms" +
					(isExceptionThrown ? " (thrown Exception)" : "");
			System.out.println(profileMessage);
		}
	}
	
}
