package lesson3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    private static final String[] INPUT_DATA = { // подаем на вход массив из слов
            "кот", "кот",
            "пёс", "пёс","пёс","пёс",
            "рыба",
            "утка",
            "ёжик", "ёжик","ёжик","ёжик",
            "мышка",
            "медведь",
            "гусь", "гусь","гусь",
            "трава",
            "дерево", "дерево"
    };


    public static void main(String[] args) {
        Map<String, Integer> frecuencyByWord = new LinkedHashMap<>();
        for (String word : INPUT_DATA) {
            Integer frecuency = frecuencyByWord.get(word);
            if (frecuency == null) {
                frecuency = 0;
            }
            frecuencyByWord.put(word, ++frecuency);
        }

            for (String word : frecuencyByWord.keySet()) {
                Integer frecuency = frecuencyByWord.get(word);
                System.out.println(word + ": " + frecuency);
            }
        }
    }

