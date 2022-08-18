package dynamicProxy;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("고양이가 사료를 먹습니다.");
    }

    @Override
    public void drink() {
        System.out.println("고양이가 물을 마십니다.");
    }
}
