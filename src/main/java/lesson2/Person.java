package lesson2;

import java.util.Objects;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

 class Base {
    private final String title = "lesson1And2.Base";
    private int count;

    public String getTitle() { // <-- геттер open (не final)
        return this.title;
    }

    public int getCount() { // <-- геттер open (не final)
        return this.count;
    }

    public void setCount(int var1) { // <-- сеттер open (не final)
        this.count = var1;
    }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Base base = (Base) o;
         return count == base.count && Objects.equals(title, base.title);
     }

     @Override
     public int hashCode() {
         return Objects.hash(title, count);
     }
 }

 final class Child extends Base {
     public static void main(String[] args) {
        Base b = new Base();
         System.out.println(b.getTitle());
        Base c = new Child();
         System.out.println(c.getTitle());

     }
    private final String title = "lesson1And2.Child";
    private int count = 42;

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setCount(int var1) {
        this.count = var1;
    }
}

