class Singleton {

    // Step 1: Create a private static object
    private static Singleton instance;

    // Step 2: Make constructor private
    private Singleton() {
        System.out.println("Object Created");
    }

    // Step 3: Provide a public method to access the object
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 == s2);
    }
}