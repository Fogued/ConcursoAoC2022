package Solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class dia02 {

    public class dia02pt1 {
        static int rock = 1;
        static int paper = 2;
        static int scissors = 3;

        static int loss = 0;
        static int draw = 3;
        static int win = 6;

        public static void main(String[] args) throws Exception {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("A", rock);
            map.put("B", paper);
            map.put("C", scissors);
            map.put("X", rock);
            map.put("Y", paper);
            map.put("Z", scissors);

            BufferedReader br = new BufferedReader(new FileReader("Inputs/input02.txt"));
            int res = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] round = line.trim().split(" ");
                String opp = round[0];
                String me = round[1];

                if (map.get(opp) == map.get(me)) {
                    res += draw;
                } else if (map.get(opp) == rock && map.get(me) == scissors
                        || map.get(opp) == paper && map.get(me) == rock
                        || map.get(opp) == scissors && map.get(me) == paper) {
                    res += loss;
                } else {
                    res += win;
                }
                res += map.get(me);
            }
            br.close();
            System.out.println(res);
        }
    }

    public class dia02pt2 {
        static int rock = 1;
        static int paper = 2;
        static int scissors = 3;

        static int loss = 0;
        static int draw = 3;
        static int win = 6;

        public static void main(String[] args) throws Exception {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("A", rock);
            map.put("B", paper);
            map.put("C", scissors);
            map.put("X", loss);
            map.put("Y", draw);
            map.put("Z", win);

            BufferedReader br = new BufferedReader(new FileReader("Inputs/input02.txt"));
            int res = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] round = line.trim().split(" ");
                String opp = round[0];
                String me = round[1];

                if (map.get(me) == loss) {
                    if (map.get(opp) == rock) {
                        res += scissors;
                    } else if (map.get(opp) == paper) {
                        res += rock;
                    } else if (map.get(opp) == scissors) {
                        res += paper;
                    }
                } else if (map.get(me) == draw) {
                    if (map.get(opp) == rock) {
                        res += rock;
                    } else if (map.get(opp) == paper) {
                        res += paper;
                    } else if (map.get(opp) == scissors) {
                        res += scissors;
                    }
                } else if (map.get(me) == win) {
                    if (map.get(opp) == rock) {
                        res += paper;
                    } else if (map.get(opp) == paper) {
                        res += scissors;
                    } else if (map.get(opp) == scissors) {
                        res += rock;
                    }
                }
                res += map.get(me);
            }
            br.close();
            System.out.println(res);
        }
    }
}