package singleton.thread_safe;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance("FOO");
        Assert.assertEquals("", "FOO", singleton.value);
    }

    /**
     * should return FOO
     * @throws InterruptedException
     */
    @Test
    public void testSingletonWithMultipleThreads() throws InterruptedException {
        Thread threadFoo = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        });

        Thread threadBar = new Thread(() -> {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        });

        threadFoo.start();
        threadBar.start();

        threadFoo.join();
        threadBar.join();
    }

}