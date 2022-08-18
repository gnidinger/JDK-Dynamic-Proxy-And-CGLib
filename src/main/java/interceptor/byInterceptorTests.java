package interceptor;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class byInterceptorTests {
    @Test
    public void byInterceptorExample() {

        Enhancer catEnhancer = new Enhancer(); // Enhancer 객체 생성
        catEnhancer.setSuperclass(Cat.class); // 타겟 클래스
        catEnhancer.setCallback(new PrintLogInterceptor()); // 로그 출력해주는 인터셉터 지정
        Cat cat = (Cat) catEnhancer.create(); // 프록시 생성

        cat.eat();
        System.out.println();
        cat.drink();
    }
}
