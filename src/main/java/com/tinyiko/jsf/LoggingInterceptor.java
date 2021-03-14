package com.tinyiko.jsf;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LoggingInterceptorBinding
@Interceptor
public class LoggingInterceptor {

	public LoggingInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		System.out.println("Logging interceptor:: logging");
		System.out.println("Method invoked is "+ ic.getMethod().getName());
		return ic.proceed();
	}

}
