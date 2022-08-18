package interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DrinkInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;

        long begin = System.currentTimeMillis(); // 시간 측정 시작
        System.out.println("----물 마시기 전----");
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("----물 마시기 끝----");
        System.out.println("메서드 실행에 걸린 시간(ms) = " + (System.currentTimeMillis() - begin)); // 시간 측정 끝

        return result;
    }
}