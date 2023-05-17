package Homework_Java_5_Mitrofanov_Filipp_4335;
import java.security.KeyException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.management.ValueExp;

import org.w3c.dom.NameList;
public class Task01 {
    public static void main(String[] args) {

        fillNameList();
    }

    public static void fillNameList() {
        HashMap<String, String> PhoneBook = new HashMap<>();
        HashMap<String, Integer> sortedNames = new HashMap<>();
        PhoneBook.put("17482", "Иван Иванов");
        PhoneBook.put("85938","Светлана Петрова");
        PhoneBook.put("04928", "Кристина Белова");
        PhoneBook.put("93847", "Анна Мусина");
        PhoneBook.put("84932", "Анна Крутова");
        PhoneBook.put("48937", "Иван Юрин");
        PhoneBook.put("389372", "Петр Лыков");
        PhoneBook.put("393283", "Павел Чернов");
        PhoneBook.put("847362", "Петр Чернышов");
        PhoneBook.put("9384623", "Мария Федорова");
        PhoneBook.put("999837", "Марина Светлова");
        PhoneBook.put("84893", "Мария Савина");
        PhoneBook.put("938472", "Мария Рыкова");
        PhoneBook.put("3938272", "Марина Лугова");
        PhoneBook.put("393084", "Анна Владимирова");
        PhoneBook.put("393685", "Анна Владимирова");
        PhoneBook.put("4928947", "Иван Мечников");
        PhoneBook.put("489372", "Петр Петин");
        PhoneBook.put("398473", "Иван Ежов");

        for (var el : PhoneBook.entrySet()) {
            String currentValue = el.getValue();
            if (sortedNames.containsKey(currentValue)) {
                Integer count = sortedNames.get(currentValue) + 1;
                sortedNames.put(currentValue, count);
            } else {
                sortedNames.put(currentValue, 1);
            }
        }
        HashMap<String, Integer> newMap = new HashMap<>();

        newMap = sortedNames.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        System.out.println(sortedNames);

        System.out.println(newMap);

    }
}

