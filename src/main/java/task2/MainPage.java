package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() throws NoSuchMethodException {
        TestMethodInfo annotation = this.getClass().getMethod("annotation").getAnnotation(TestMethodInfo.class);
        Priority priority = annotation.priority();
        String author = annotation.author();
        String lastModified = annotation.lastModified();
        System.out.println(priority + ", " + author + ", " + lastModified);
        assertEquals(1, 1);
    }
}





