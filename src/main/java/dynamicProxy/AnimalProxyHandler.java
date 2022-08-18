package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalProxyHandler implements InvocationHandler {

    Object target;

    public AnimalProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        if(method.getName().equals("eat")) { // 메서드가 eat 이라면

            long begin = System.currentTimeMillis(); // 시간 측정 시작

            System.out.println("----사료 먹기 전----");
            result = method.invoke(target, args); // 메서드 호출
            System.out.println("----사료 먹기 끝----");

            System.out.println("메서드 실행에 걸린 시간(ms) = " + (System.currentTimeMillis() - begin)); // 시간 측정 끝

        } else if(method.getName().equals("drink")) { // 메서드가 drink 라면

            long begin = System.currentTimeMillis(); // 시간 측정 시작

            System.out.println("----물 마시기 전----");
            result = method.invoke(target, args); // 메서드 호출
            System.out.println("----물 마시기 끝----");

            System.out.println("메서드 실행에 걸린 시간(ms) = " + (System.currentTimeMillis() - begin)); // 시간 측정 끝
        }

        return result; // 호출결과 반환
    }
}
