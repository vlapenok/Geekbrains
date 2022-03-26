package java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<Long>> phoneBook = new HashMap<>();

    public void add(String name, long phone) {
        if(!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        phoneBook.get(name).add(phone);
    }

    public void get(String name) {
        if(phoneBook.containsKey(name)) {
            System.out.println("Телефон " + name + ": " + phoneBook.get(name));
        } else {
            System.out.println("Такого абонента нет в записной книге");
        }
    }
}
