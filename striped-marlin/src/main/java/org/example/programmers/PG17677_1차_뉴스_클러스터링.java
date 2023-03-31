package org.example.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PG17677_1차_뉴스_클러스터링 {
    public static int solution(String str1, String str2) {
        String[] firstString = new String[str1.length()-1];
        String[] secondString = new String[str2.length()-1];

        for(int i = 0; i< str1.length()-1; i++) {
            if(str1.charAt(i) < 'A' || str1.charAt(i) >'Z') {
                if(str1.charAt(i) < 'a' || str1.charAt(i) >'z') {
                    continue;
                }
            }
            if(str1.charAt(i+1) < 'A' || str1.charAt(i+1) >'Z') {
                if(str1.charAt(i+1) < 'a' || str1.charAt(i+1) >'z') {
                    continue;
                }
            }
            String tmp = str1.substring(i, i+2).toLowerCase(Locale.ROOT);
            firstString[i] = tmp;
        }
        for(int i = 0; i<str2.length()-1; i++) {
            if(str2.charAt(i) < 'A' || str2.charAt(i) >'Z') {
                if(str2.charAt(i) < 'a' || str2.charAt(i) >'z') {
                    continue;
                }
            }
            if(str2.charAt(i+1) < 'A' || str2.charAt(i+1) >'Z') {
                if(str2.charAt(i+1) < 'a' || str2.charAt(i+1) >'z') {
                    continue;
                }
            }
            String tmp = str2.substring(i, i+2).toLowerCase(Locale.ROOT);
            secondString[i] = tmp;
        }

        List<String> intersection = new ArrayList<>();
        boolean[] visited = new boolean[secondString.length];
        for(int i = 0; i<firstString.length; i++) {
            for(int j = 0; j< secondString.length; j++) {
                if(firstString[i] == null) continue;
                if(firstString[i].equals(secondString[j]) && !visited[j]) {
                    intersection.add(firstString[i]);
                    visited[j] = true;
                    break;
                }
            }
        }
        int firstStringCount = 0;
        for(int i = 0; i< firstString.length; i++) {
            if(firstString[i] != null) {
                firstStringCount++;
            }
        }
        int secondStringCount = 0;
        for(int i = 0; i<secondString.length; i++) {
            if(secondString[i] != null) {
                secondStringCount++;
            }
        }
        if(firstStringCount == 0 && secondStringCount == 0) {
            return 65536;
        }

        double union = firstStringCount + secondStringCount;
        union -= intersection.size();

        double j = (double) intersection.size() / union;
        j *= 65536;

        return (int) Math.floor(j);
    }

    public static void main(String[] args) {
        System.out.println(solution("abab", "baba"));
        //ab ba ab
        //ba ab ba
    }
}
