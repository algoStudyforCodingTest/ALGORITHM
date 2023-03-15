package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i<test_case; i++) {
            int count = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j<count; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if (Objects.equals(command, "I")) {
                    if(!map.containsKey(number)) {
                        map.put(number, 1);
                    } else {
                        int value = map.get(number);
                        value += 1;
                        map.put(number, value);
                    }
                }
                else if (Objects.equals(command, "D")) {
                    if (number == -1) {
                        if(map.size() > 0) {
                            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
                            if(entry.getValue() > 1) {
                                int value = entry.getValue() - 1;
                                map.put(entry.getKey(), value);
                            }
                        }
                    } else if (number == 1) {
                        if(map.size() > 0) {
                            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
                            if(entry.getValue() > 1) {
                                int value = entry.getValue() -1 ;
                                map.put(entry.getKey(), value);
                            }
                        }
                    }
                }
            }
            if(map.size() < 1) {
                System.out.println("EMPTY");
            } else {
                int first = map.firstKey();
                int last = map.lastKey();
                System.out.println(last + " " + first);
            }
        }
    }
}
