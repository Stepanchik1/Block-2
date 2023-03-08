import java.util.*;

public class ServiceClass {

    public static void operate() {
        String text = setString();
        if (cutString(text) == null) {
            System.out.println("В тексте нет слов");
            return;
        } else {
            LinkedHashMap<String, Integer> treeMap = wordsMap(cutString(text));
            System.out.println(mapToString(treeMap));
            return;
        }
    }

    public static void operate(String text) {
        if (cutString(text) == null) {
            System.out.println("В тексте нет слов");
            return;
        } else {
            LinkedHashMap<String, Integer> treeMap = wordsMap(cutString(text));
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

    public static LinkedHashMap<String, Integer> wordsMap(String[] words) {
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
        if (words == null) {
            return null;
        } else {
            Arrays.stream(words).sorted().toArray();
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
                    hashMap.put(word, count);
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            } else {
                return hashMap;
            }
        }
    }
    public static String mapToString(Map map) {
        return "Всего в тексте " + map.size() + " слов:\n" + map.toString().replace("{", "").replace("}", "").replace(", ", "\n");
    }
}
