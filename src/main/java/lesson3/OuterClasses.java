package lesson3;

public class OuterClasses {

    public class JavaNested {

        public void print() {
            System.out.println("test");
        }

        public OuterClasses getOuterClasses() {
            return OuterClasses.this;
        }
    }

    private  class JavaNested2 {}

    public static void main(String[] args) {

//        JavaNested nested = new JavaNested();
        JavaNested2 nested = new OuterClasses().new JavaNested2();
    }

    public void test() {
        JavaNested nested = new JavaNested();
        nested.print();
        JavaNested2 nested2 = this.new JavaNested2();
    }
}
