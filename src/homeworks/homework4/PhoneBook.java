package homeworks.homework4;

import java.util.HashMap;

public class PhoneBook {
    HashMap<Integer, String> phoneBook = new HashMap<>();

    public void add(String lastname, Integer phone) {
        phoneBook.put(phone, lastname);
        System.out.println("В справочник записан " + lastname + " с номером " + phone);
    }

    public String get(String lastname) {
        if (phoneBook.containsValue(lastname)) {
            String result = "Номера телефонов с фамилией " + lastname + " : ";
            for (Integer key : phoneBook.keySet()) {
                if (phoneBook.get(key).equals(lastname)) result += key + "; ";
            }
            return result;
        } else return "Фамилии " + lastname + " в справочнике нет.";
    }

}
