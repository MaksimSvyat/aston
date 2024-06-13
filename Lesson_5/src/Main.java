import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"планета", "спутник", "планета", "звезда", "спутник", "комета", "планета", "звезда",
                "спутник", "метеор"};

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (w.equals(word)) {
                    count++;
                }
            }
            wordCount.put(word, count);
        }

        System.out.println("Список уникальных слов: " + uniqueWords);
        System.out.println("Количество повторений каждого слова: " + wordCount);

        Phonebook phonebook = new Phonebook();

        phonebook.add("Путин", "1234567890");
        phonebook.add("Лукашенко", "1234567899");
        phonebook.add("Путин", "0987654321");

        System.out.println("Номера телефонов по фамилии Лукашенко: " + phonebook.get("Лукашенко"));
        System.out.println("Номера телефонов по фамилии Путин: " + phonebook.get("Путин"));
        System.out.println("Номера телефонов по фамилии Медведев: " + phonebook.get("Медведев"));
    }
}