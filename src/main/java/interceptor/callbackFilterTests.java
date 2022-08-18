package interceptor;

import org.junit.Test;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;


public class callbackFilterTests {
    @Test
    public void callbackFilterExample() { // 콜백 필터를 이용해 필터 조건(메서드)에 따라 다른 인터셉터 적용

        Enhancer catEnhancer = new Enhancer(); // Enhancer 객체 생성
        catEnhancer.setSuperclass(Cat.class); // 타겟 클래스
        // 메서드 이름에 따라 인덱스 반환해주는 콜백 필터 지정, 0 반환 시 EatInterceptor, 1 반환 시 DrinkInterceptor
        catEnhancer.setCallbackFilter(new AnimalMethodCallbackFilter());
        catEnhancer.setCallbacks(new Callback[]{ // 콜백 배열 지정
                new EatInterceptor(), // 0
                new DrinkInterceptor() // 1
        });
        Cat cat = (Cat) catEnhancer.create(); // 프록시 생성

        cat.eat();
        System.out.println();
        cat.drink();
    }
}
