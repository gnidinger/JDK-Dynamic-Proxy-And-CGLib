package interceptor;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class PrintLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;

        long begin = System.currentTimeMillis();  // 시간 측정 시작
        System.out.println("----메서드 실행 전----");
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("----메서드 실행 후----");
        System.out.println("메서드 실행에 걸린 시간(ms) = " + (System.currentTimeMillis() - begin)); // 시간 측정 끝

        return result;
    }
}
