package task1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method m, Object[] args){
        String methodName = "textInputSearch";
        String xpath1 = ".//*[@test-attr='input_search']";
        String xpath2 = ".//*[@test-attr='button_search']";
        return m.getName().equals(methodName)? xpath1 : xpath2;
    }
}
