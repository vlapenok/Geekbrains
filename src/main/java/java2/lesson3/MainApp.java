package java2.lesson3;

/*
1.  Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
    вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.

2.  Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
    телефонных номеров. В этот телефонный справочник с помощью метода add() можно
    добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
    учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
    лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
    через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
    справочника.
 */

import java.util.*;

public class MainApp {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        uniqueWords();
        phoneBook();
    }

    public static void uniqueWords() {
        String[] words = {
                "Apple", "Camel", "Aisberg", "Butterfly", "Milk", "Peach", "Watermelon", "Java", "Mother", "Father",
                "Pen", "Apricot", "Town", "City", "Monkey", "Key", "Table", "Ananas", "Aisberg", "Butterfly", "Java",
                "Pen", "Apricot", "Monkey", "Key", "Key", "Table", "Peach", "Watermelon", "Town", "City", "Java"
        };

        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        System.out.println(wordsSet);

        //Первый способ
        for(String w : wordsSet) {
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                if(w.equals(words[i])) {
                    count++;
                }
            }
            System.out.print(w + "=" + count + ", ");
        }
        System.out.println();

        //Второй способ
        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word : words) {
            if(!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
        }
        System.out.println(wordsMap);

        //Третий способ
        wordsMap = new HashMap<>();
        for(String w3 : words) {
            wordsMap.put(w3, wordsMap.getOrDefault(w3, 0) + 1);
        }
        System.out.println(wordsMap);
    }

    public static void phoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Vadim", 79043330999L);
        phoneBook.add("Vasya", 79043334558L);
        phoneBook.add("Vasya", 79110000000L);
        phoneBook.add("Zashiba", 79043331836L);
        phoneBook.add("Eugene", 79043314905L);

        phoneBook.get("Vasya");
        phoneBook.get("Eugene");
    }
}
