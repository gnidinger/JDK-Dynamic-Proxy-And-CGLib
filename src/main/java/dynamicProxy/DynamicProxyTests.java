package dynamicProxy;

import org.junit.Test;
import java.lang.reflect.Proxy;

public class DynamicProxyTests {
    @Test
    public void dynamicProxyExample() {
        // 동적으로 프록시 생성
        // cat
        Animal cat = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), // 클래스 로더
                new Class[]{Animal.class}, // 타겟 인터페이스
                new AnimalProxyHandler(new Cat())); // 타겟의 정보가 포함된 핸들러
        // dog
        Animal dog = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                new Class[]{Animal.class},
                new AnimalProxyHandler(new Dog()));

        // 프록시를 통해 타겟 인스턴스 메서드 호출
        cat.eat();
        System.out.println();
        cat.drink();
        System.out.println();

        dog.eat();
        System.out.println();
        dog.drink();
        System.out.println();
    }
}
