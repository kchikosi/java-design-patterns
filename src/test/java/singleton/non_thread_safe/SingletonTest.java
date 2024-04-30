package singleton.non_thread_safe;

import org.junit.Test;

public class SingletonTest {
    /**
     * should return 2 instances
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