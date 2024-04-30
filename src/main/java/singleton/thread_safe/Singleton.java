package singleton.thread_safe;

/**
 * check out https://www.youtube.com/watch?v=tSZn4wkBIu8&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=2
 */
public class Singleton {

    // The field must be declared volatile so that double check lock would work
    // correctly.
    public static volatile Singleton instance;
    public String value;


    /**
     * @param value
     * @link test.singleton.Singletontest#testSingleWithMultipleThreads()
     */
    private Singleton(String value) {
        // this delay is to ensure that multiple threads can hit this method at the same time
        // @see SingletonTest#testSingleWithMultipleThreads()
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
