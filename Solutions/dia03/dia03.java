package Solutions.dia03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dia03 {
    static String line;
    static int sum = 0;

    static HashMap<Character, Integer> map = new HashMap<>();
    static List<Character> list1 = new ArrayList<Character>();
    static List<Character> list2 = new ArrayList<Character>();
    static List<Character> items = new ArrayList<Character>();

    public static HashMap<Character, Integer> abcMap(HashMap<Character, Integer> map) {
        int i = 1;
        char c = 'a';
        while (i < 27) {
            map.put(c, i);
            c++;
            i++;
        }
        c = 'A';
        while (i < 53) {
            map.put(c, i);
            c++;
            i++;
        }
        return map;
    }

    public static int sum(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            sum += map.get(list.get(i));
        }
        return sum;
    }

    public static List<Character> stringToList(String str) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list;
    }

    public class dia03pt1 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader("Inputs/input03.txt"));
            map = abcMap(map);
            while ((line = br.readLine()) != null) {
                String str = line.trim();
                for (int i = 0; i < str.length() / 2; i++) {
                    list1.add(str.charAt(i));
                }
                for (int i = str.length() / 2; i < str.length() && list1.size() != 0; i++) {
                    if (list1.contains(str.charAt(i))) {
                        items.add(str.charAt(i));
                        list1.removeAll(list1);
                    }
                }
            }
            br.close();
            System.out.println(sum(items));
        }
    }

    public class dia03pt2 {
        public static void main(String[] args) throws Exception {
            map = abcMap(map);
            BufferedReader br = new BufferedReader(new FileReader("Inputs/input03.txt"));
            while ((line = br.readLine()) != null) {
                String str1 = line.trim();
                list1 = stringToList(str1);
                line = br.readLine();
                String str2 = line.trim();
                list2 = stringToList(str2);
                line = br.readLine();
                String str3 = line.trim();
                for (int i = 0; i < str3.length(); i++) {
                    if (list1.contains(str3.charAt(i)) && list2.contains(str3.charAt(i))) {
                        items.add(str3.charAt(i));
                        list1.removeAll(list1);
                        list2.removeAll(list2);
                    }
                }
            }
            br.close();
            System.out.println(sum(items));
        }
    }

}
