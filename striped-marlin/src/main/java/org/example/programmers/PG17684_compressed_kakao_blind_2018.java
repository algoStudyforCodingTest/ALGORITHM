package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG17684_compressed_kakao_blind_2018 {
    public static int[] solution(String msg) {
        /*
        KAKAO
        K -> 11
        A -> 1
        KA -> 27
        O -> 15
        */
        List<String> list = new ArrayList<>();
        for(int i = 0; i<26; i++) {
            char c = (char) (i + 'A');
            list.add(String.valueOf(c));
        }
        String tmp = "";
        List<Integer> index = new ArrayList<>();
        int k = 0;
        outer:
        for(int i = 0; i<msg.length();i++) {
            for(int j = i+1; j<=msg.length(); j++) {
                String str = msg.substring(i, j);

                if(list.contains(str)) {
                    tmp = str;
                } else {
                    list.add(str);
                    int idx = list.indexOf(tmp);
                    index.add(idx + 1);
                    i = j-2;
                    k = j;
                    break;
                }
            }
        }
        if(msg.length() > 1) {
            if(list.contains(msg.substring(k-1))) {
                int idx = list.indexOf(msg.substring(k-1));
                index.add(idx+1);
            } else {
                list.add(msg.substring(k-1));
                index.add(list.indexOf(msg.substring(k-1))+1);
            }
        } else {
            index.add(list.indexOf(msg)+1);
        }

        int[] result = index.stream()
                .mapToInt(i -> i)
                .toArray();
//        System.out.println(list);
//        System.out.println(msg.substring(k-1));
        return result;
    }

    public static void main(String[] args) {
        String msg = "A";
        System.out.println(Arrays.toString(solution(msg)));
    }

}
