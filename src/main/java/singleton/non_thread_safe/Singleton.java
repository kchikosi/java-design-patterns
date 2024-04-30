package singleton.non_thread_safe;

/**
 * check out https://www.youtube.com/watch?v=tSZn4wkBIu8&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=2
 */
public class Singleton {

    //volatile keyword omitted
    public static Singleton instance;
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

        if (instance != null) {
            return instance;
        }

        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;

    }
}
