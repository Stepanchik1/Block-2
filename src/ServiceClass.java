import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ServiceClass {

    public static void operate() {
        String text = setString();
        if (cutString(text) == null) {
            System.out.println("В тексте нет слов");
            return;
        } else {
            TreeMap<String, Integer> treeMap = wordsMap(cutString(text));
            System.out.println(mapToString(treeMap));
            return;
        }
    }

    public static void operate(String text) {
        if (cutString(text) == null) {
            System.out.println("В тексте нет слов");
            return;
        } else {
            TreeMap<String, Integer> treeMap = wordsMap(cutString(text));
            System.out.println(mapToString(treeMap));
            return;
        }
    }

    public static String setString() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine().trim();
        return text;
    }

    public static String[] cutString(String text) {
        String emptyText = text.replace(",", "").replace(".", "").replace(":", "").replace(";", "").replace("?", "").replace("!", "").replace(")", "").replace("(", "");
        String lowText = emptyText.toLowerCase().trim();
        String finish = lowText.replace("-", "").replace("<", "").replace(">", "").replace("$", "").replace("^", "").replace("%", "").replace("\"", "").replace("+", "");
        if (finish.isEmpty() || finish == null) {
            return null;
        } else {
            String[] words = finish.split(" ");
            return words;
        }
    }

    public static TreeMap<String, Integer> wordsMap(String[] words) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word != null) {
                int count = 0;
                for (int j = 0; j < words.length; j++) {
                    if (word.equals(words[j])) {
                        count++;
                        words[j] = null;
                    }
                }
                treeMap.put(word, count);
            }
        }
        if (treeMap.isEmpty()) {
            return null;
        } else {
            return treeMap;
        }
    }

    public static String mapToString(Map map) {
        return "Всего в тексте " + map.size() + " слов:\n" + map.toString().replace("{", "").replace("}", "").replace(", ", "\n");
    }
}


