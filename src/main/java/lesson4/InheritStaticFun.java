package lesson4;

public class InheritStaticFun {

}

class BaseJava{
    public static void hello() {
        System.out.println("hello Base");
    }
}
class ChildJava extends BaseJava{
    public static void hello() {
        System.out.println("hello Child");
    }
}


