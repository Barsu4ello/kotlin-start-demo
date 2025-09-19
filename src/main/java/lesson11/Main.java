package lesson11;

public class Main {
    private static class InnerMain {
        @Override
        public String toString() {
            return "InnerMain{}";
        }

        public String getStr() {
            return "123";
        }
    }

    public InnerMain getInnerMain() {
        return new InnerMain();
    }
}


//Хоть и доступа к InnerMain нету, но вызвать  main.getInnerMain() можно. И даже вызвать его toString или Objects.hashCode(). Но до других методов доступа не будет.
class Test {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getInnerMain()); // вызовет нормальный toString() у класса InnerMain

        // Не будет работать
//        Main.InnerMain innerMain = main.getInnerMain();
//        System.out.println(innerMain);

    }
}
