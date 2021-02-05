package task1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodInterception {
    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {
        MainPage mainPage = new MainPageImpl();
        ClassLoader classLoader = mainPage.getClass().getClassLoader();
        Class<?>[] interfaces = mainPage.getClass().getInterfaces();

        CustomInvocationHandler handler = new CustomInvocationHandler();
        return (MainPage) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}