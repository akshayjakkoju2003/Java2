import java.util.HashMap;

public class AnagramChecker {

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        boolean areAnagrams = checkAnagrams(str1, str2);
        System.out.println(areAnagrams); // Output: true

        String str3 = "restful";
        String str4 = "fluster";

        areAnagrams = checkAnagrams(str3, str4);
        System.out.println(areAnagrams); // Output: true
    }

    public static boolean checkAnagrams(String str1, String str2) {
        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            charCountMap.put(c, count - 1);
        }

        return true;
    }
}