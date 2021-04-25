package Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class Transformer implements IAnnotationTransformer,IRetryAnalyzer {
	
	
		
	
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(Transformer.class);
		
	}
		
	
int failedcount = 0;
	
	int limit = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(failedcount<limit)
		{
			failedcount++;
			return true;
		}
		
		return false;
	}


}
