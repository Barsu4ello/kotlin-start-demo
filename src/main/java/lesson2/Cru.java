package lesson2;

public enum Cru {
    CRU,
    PREMIER,
    GRAND();

    Cru() {
        System.out.println("CRU" + this.name());
    }

    public String toString() {
        return "lesson1And2.Cru{}";
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Cru.CRU);
    }
}
