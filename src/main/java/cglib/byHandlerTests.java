package cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;




public class byHandlerTests {
    @Test
    public void byHandlerExample() {

        Enhancer rabbitEnhancer = new Enhancer(); // Enhancer 객체 생성
        rabbitEnhancer.setSuperclass(Cat.class); // 타겟 클래스
        rabbitEnhancer.setCallback(new AnimalProxyCGLibHandler(new Cat())); // 핸들러 지정
        Cat cat = (Cat) rabbitEnhancer.create(); // 프록시 생성

        cat.eat();
        System.out.println();
        cat.drink();
    }
}