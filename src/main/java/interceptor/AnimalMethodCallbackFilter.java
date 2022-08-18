package interceptor;

import net.sf.cglib.proxy.CallbackFilter;
import java.lang.reflect.Method;

// 메서드가 eat 이냐 drink 냐에 따라 해당하는 인덱스 반환
public class AnimalMethodCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("eat")) return 0;
        if(method.getName().equals("drink")) return 1;
        return 0; // 기본 값 = 0
    }
}