package dynamicProxy;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("강아지가 사료를 먹습니다.");
    }

    @Override
    public void drink() {
        System.out.println("강아지가 물을 마십니다.");
    }
}
