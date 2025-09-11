package lesson3;

public class InitBlock {
    static {
        System.out.println("Static InitBlock");
    }

    {
        System.out.println("InitBlock");
    }

    public InitBlock() {
        System.out.println("Cons");
    }

    public static void main(String[] args) {
        InitBlock init = new InitBlock();
    }
}
