package lesson4;

public class SingletonJava {

    private SingletonJava() {
    }

    private static SingletonJava instance;

    public static SingletonJava getInstance() {
        if (instance == null) {
            instance = new SingletonJava();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonJava singleton = SingletonJava.getInstance();
    }
}
