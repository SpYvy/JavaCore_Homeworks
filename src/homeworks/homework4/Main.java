package homeworks.homework4;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static String[] words = {"Каждый","Охотник","Желает","Знать","Где","Сидит","Фазан","Красный","Оранжевый","Знать",
            "Зеленый","Где","Синий","Фиолетовый","Фазан","Знать","Охотник","Сидит","В","Траве"};

    public static void main(String[] args) {

        Set<String> uniqueWords = new HashSet<>(20);

        for (String word : words) { //Collections.addAll(uniqueWords, words);
            uniqueWords.add(word);
        }
        System.out.println("Cписок уникальных слов: " + uniqueWords);

        Set<String> wordsCounter = new HashSet<>();

        for (String word : words) { //Цикл проходит по каждому слову в массиве
            int i = 0;
            for (String e : words) { //Цикл сравнивает слово с каждым словом в массиве
                if (e == word) i++;
            }
            wordsCounter.add("<" + word + "> встречается " + i + " раз."); //HashSet сохраняет только в случае нового слова.
        }
        System.out.println(wordsCounter);
        System.out.println();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Романов", 354485);
        phoneBook.add("Синицин", 446750);
        phoneBook.add("Селезнев", 441234);
        phoneBook.add("Зеленый", 443050);
        phoneBook.add("Синицин", 446730);

        System.out.println(phoneBook.get("Синицин"));
        System.out.println(phoneBook.get("Зеленый"));
        System.out.println(phoneBook.get("Собакин"));
    }
}
