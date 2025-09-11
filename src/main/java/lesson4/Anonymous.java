package lesson4;

public class Anonymous {
    public static void main(String[] args) {
        ViewJava view = new ViewJava();
        view.setInClickListener(() -> System.out.println("Anonymous"));
    }
}


interface ClickListenerJava {
    void click();
}

class ViewJava {
    void setInClickListener( ClickListenerJava listener) {
        listener.click();
    }
}
