package lesson3;

public class Main {
    public static final String test = null;

    public static void main(String[] args) {
        long val1 = 100;
        int val2 = 10;
        long val3 = val2;
        test();
    }
    public static final void test() {
        System.out.println("123");
    }

    public void test2(){
        test2();
    }
}

interface Test{
    int i = 100;
}