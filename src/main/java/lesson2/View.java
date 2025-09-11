package lesson2;

public interface View {

    public final static String s = "123";

    static void test() {
        System.out.println(s);
    }

    void click();
    default void whoAmI(){
        System.out.println("I am view");
    }
}

interface Shape {
    default void whoAmI(){
        System.out.println("I am shape");
    }
}

class Button implements View, Shape {

    @Override
    public void click() {
        System.out.println("Click button");
    }

    @Override
    public void whoAmI() {
        View.super.whoAmI();
        View.super.whoAmI();
    }

//    @Override
//    public void whoAmI() {
//        System.out.println("I am button");
//    }
}
