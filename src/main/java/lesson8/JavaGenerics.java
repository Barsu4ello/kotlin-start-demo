package lesson8;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {
    public static void main(String[] args) {
        //При extends нельзя писать ибо не понятно какой наследник внутри и в лист Integer можно было бы положить Double
        List<? extends Number> listNumbers1 = new ArrayList<Integer>();
//        listNumbers1.add(12); // ошибка
        listNumbers1.addLast(null); // null можно ибо у все объекты могут быть null
        Number number = listNumbers1.get(0); // не понятно что за наследник поэтому тип слева не ниже Number (или нужен cast)

        // Тут справа можно указать только Number или родителя
        // Что позволяет добавлять любой объект ниже типа Number безопасно ибо они будут точно наследниками типа правой стороны
        List<? super Number> listNumbers2 = new ArrayList<Object>(); // или можно Number указать справа
        listNumbers2.addLast(12); // все хорошо работает ибо 12 наследник правого типа
//        Number object = listNumbers2.get(0); // не сработает или возможно что внутри был массив объектов(а соответственно там может быть любой объект)
        Object object = listNumbers2.get(0); // работает ибо выше Object никого нет
    }
}

