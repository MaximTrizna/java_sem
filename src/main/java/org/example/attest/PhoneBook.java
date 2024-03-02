package org.example.attest;

/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными
телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть
отсортирован по убыванию числа телефонов.
 */

import java.util.*;

public class PhoneBook {
    private static final HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    // Добавление номера телефона
    public void add(String name, String phoneNum) {
        ArrayList<String> phoneNumbs = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbs.add(phoneNum);
        phoneBook.put(name, phoneNumbs);
    }
    // Вывод с сортировкой по убыванию количеству номеров
    private static void displayItems() {
        List<Map.Entry<String, ArrayList<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        System.out.println("Записи в телефонной книге (отсортированы по убыванию числа телефонов):\n");
        for (Map.Entry<String, ArrayList<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Петров", "+1111222233");
        phoneBook.add("Иванов", "+1234567890");
        phoneBook.add("Иванов", "+0987654321");
        phoneBook.add("Сидоров", "+2516443354");
        phoneBook.add("Петров", "+5128435454");
        phoneBook.add("Иванов", "+5168435135");

        displayItems();
    }
}
