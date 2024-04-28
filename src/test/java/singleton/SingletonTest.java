package singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance("FOO");
        Assert.assertEquals("", "FOO", singleton.value);
    }

    @Test
    public void testSingleWithMultipleThreads() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        });

        Thread t2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}