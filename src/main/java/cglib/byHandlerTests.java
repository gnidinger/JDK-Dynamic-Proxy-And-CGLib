package cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class byHandlerTests {
    @Test
    public void byHandlerExample() {

        Enhancer catEnhancer = new Enhancer(); // Enhancer 객체 생성
        catEnhancer.setSuperclass(Cat.class); // 타겟 클래스
        catEnhancer.setCallback(new AnimalProxyCGLibHandler(new Cat())); // 핸들러 지정
        Cat cat = (Cat) catEnhancer.create(); // 프록시 생성

        cat.eat();
        System.out.println();
        cat.drink();
    }
}